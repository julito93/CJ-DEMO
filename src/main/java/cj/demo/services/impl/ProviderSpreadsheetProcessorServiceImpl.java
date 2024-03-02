package cj.demo.services.impl;

import cj.demo.bo.EmployeeBO;
import cj.demo.exceptions.EmployeeException;
import cj.demo.mappers.EmployeeMapper;
import cj.demo.models.Employee;
import cj.demo.repositories.ProviderSpreadSheetRepository;
import cj.demo.services.ProvidersSpreadsheetProcessorService;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProviderSpreadsheetProcessorServiceImpl implements ProvidersSpreadsheetProcessorService {

    private final ProviderSpreadSheetRepository repository;
    private final EmployeeMapper employeeMapper;

    @Override
    public float sumEmployeesMonthlyAmounts(int scenario) throws EmployeeException {

        List<Employee> employeeList = repository.getEmployees(scenario);

        Optional<Employee> inconsistency = employeeList.stream()
            .filter(employee -> employee.getMonthlyAmount()<=0L
            ||employee.getName() ==null
            ||  employee.getName().isBlank()
            || employee.getName().isEmpty()
        ).findFirst();

        if (inconsistency.isPresent())
        {
            throw new EmployeeException(inconsistency.get().getId());
        }

        List<EmployeeBO> employeeBOList = employeeMapper.toBOList(employeeList);
        return employeeBOList.stream()
            .filter(EmployeeBO::getStatusActive)
            .map(EmployeeBO::getMonthlyAmount)
            .reduce(Float.MIN_VALUE, (Float::sum));
    }
}
