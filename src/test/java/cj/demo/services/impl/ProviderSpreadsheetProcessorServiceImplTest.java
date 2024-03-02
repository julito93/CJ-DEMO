package cj.demo.services.impl;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import cj.demo.bo.EmployeeBO;
import cj.demo.exceptions.EmployeeException;
import cj.demo.mappers.EmployeeMapper;
import cj.demo.models.Employee;
import cj.demo.repositories.ProviderSpreadSheetRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProviderSpreadsheetProcessorServiceImplTest {

    @Mock
    private ProviderSpreadSheetRepository repository;

    @Mock
    private EmployeeMapper employeeMapper;

    @InjectMocks
    private ProviderSpreadsheetProcessorServiceImpl underTest;

    @Test
    void test_sumEmployeesMonthlyAmounts() {
        List<Employee> employeeList = List.of(
            Employee.builder()
                .name("test Employee 1")
                .statusActive(Boolean.TRUE)
                .monthlyAmount(10F)
                .build(),
            Employee.builder()
                .name("test Employee 2")
                .statusActive(Boolean.TRUE)
                .monthlyAmount(20F)
                .build(),
            Employee.builder()
                .name("test Employee 3")
                .statusActive(Boolean.FALSE)
                .monthlyAmount(10F)
                .build());
        List<EmployeeBO> employeeBOList = List.of(
            EmployeeBO.builder()
                .name("test Employee 1")
                .statusActive(Boolean.TRUE)
                .monthlyAmount(10F)
                .build(),
            EmployeeBO.builder()
                .name("test Employee 2")
                .statusActive(Boolean.TRUE)
                .monthlyAmount(20F)
                .build(),
            EmployeeBO.builder()
                .name("test Employee 3")
                .statusActive(Boolean.FALSE)
                .monthlyAmount(10F)
                .build());

        when(repository.getEmployees(anyInt())).thenReturn(employeeList);
        when(employeeMapper.toBOList(anyList())).thenReturn(employeeBOList);

        assertAll(() -> assertEquals(30F, underTest.sumEmployeesMonthlyAmounts(0)),
            () -> verify(repository, atLeastOnce()).getEmployees(anyInt()),
            () -> verify(employeeMapper, atLeastOnce()).toBOList(anyList()));
    }

    @Test
    void test_sumEmployeesMonthlyAmounts_name_empty() {
        List<Employee> employeeList = List.of(
            Employee.builder()
                .id(1L)
                .statusActive(Boolean.TRUE)
                .monthlyAmount(10F)
                .build(),
            Employee.builder()
                .id(2L)
                .name("test Employee 2")
                .statusActive(Boolean.TRUE)
                .monthlyAmount(20F)
                .build(),
            Employee.builder()
                .id(3L)
                .name("test Employee 3")
                .statusActive(Boolean.FALSE)
                .monthlyAmount(10F)
                .build());

        when(repository.getEmployees(anyInt())).thenReturn(employeeList);

        assertAll(
            () -> assertThrows(EmployeeException.class, () -> underTest.sumEmployeesMonthlyAmounts(1)),
            () -> verify(repository, atLeastOnce()).getEmployees(anyInt()));
    }
    @Test
    void test_sumEmployeesMonthlyAmounts_0_amount() {
        List<Employee> employeeList = List.of(
            Employee.builder()
                .id(1L)
                .statusActive(Boolean.TRUE)
                .monthlyAmount(0F)
                .build(),
            Employee.builder()
                .id(2L)
                .name("test Employee 2")
                .statusActive(Boolean.TRUE)
                .monthlyAmount(20F)
                .build(),
            Employee.builder()
                .id(3L)
                .name("test Employee 3")
                .statusActive(Boolean.FALSE)
                .monthlyAmount(10F)
                .build());


        when(repository.getEmployees(anyInt())).thenReturn(employeeList);

        assertAll(
            () -> assertThrows(EmployeeException.class, () -> underTest.sumEmployeesMonthlyAmounts(1)),
            () -> verify(repository, atLeastOnce()).getEmployees(anyInt()));
    }
}