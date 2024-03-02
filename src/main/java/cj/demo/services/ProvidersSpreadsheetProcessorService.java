package cj.demo.services;

import cj.demo.exceptions.EmployeeException;

public interface ProvidersSpreadsheetProcessorService {


    float sumEmployeesMonthlyAmounts(int scenario) throws EmployeeException;
}
