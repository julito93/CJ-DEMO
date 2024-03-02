package cj.demo.service.impl;

import cj.demo.bo.EmployeeBO;
import cj.demo.mapper.EmployeeMapper;
import cj.demo.model.Employee;
import cj.demo.repository.ProviderSpreadSheetRepository;
import cj.demo.service.ProvidersSpreadsheetProcessorService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProviderSpreadsheetProcessorServiceImpl implements ProvidersSpreadsheetProcessorService {

    private final ProviderSpreadSheetRepository repository;
    private final EmployeeMapper employeeMapper;

    @Override
    public float sumEmployeesMonthlyAmounts() {
        List<Employee> employeeList = repository.getEmployees();
        List<EmployeeBO> employeeBOList = employeeMapper.toBOList(employeeList);
        return employeeBOList.stream()
            .filter(EmployeeBO::getStatusActive)
            .map(EmployeeBO::getMonthlyAmount)
            .reduce(Float.MIN_VALUE, (Float::sum));
    }
}
