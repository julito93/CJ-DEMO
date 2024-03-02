package cj.demo.repository;

import cj.demo.model.Employee;
import java.util.List;

public interface ProviderSpreadSheetRepository {

    List<Employee> getEmployees();
}
