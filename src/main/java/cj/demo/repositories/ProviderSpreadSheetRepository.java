package cj.demo.repositories;

import cj.demo.models.Employee;
import java.util.List;

public interface ProviderSpreadSheetRepository {

    List<Employee> getEmployees(int scenario);
}
