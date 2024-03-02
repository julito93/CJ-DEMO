package cj.demo.repository;

import cj.demo.model.Employee;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ProviderSpreadSheetRepositoryImpl implements ProviderSpreadSheetRepository {

    @Override
    public List<Employee> getEmployees() {
        return List.of(
            Employee.builder()
                .name("test Employee 1")
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
    }
}
