package cj.demo.repositories;

import cj.demo.models.Employee;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ProviderSpreadSheetRepositoryImpl implements ProviderSpreadSheetRepository {

    @Override
    public List<Employee> getEmployees(int scenario) {
        return switch (scenario)
        {
            case 0 ->List.of(
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
            case 1 -> List.of(
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
            case 2 -> List.of(
                Employee.builder()
                    .name("test Employee 1")
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
            default -> throw new IllegalStateException("Unexpected value: " + scenario);
        };
    }
}
