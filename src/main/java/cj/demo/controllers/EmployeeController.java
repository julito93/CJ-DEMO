package cj.demo.controllers;

import cj.demo.exceptions.EmployeeException;
import cj.demo.services.ProvidersSpreadsheetProcessorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private final ProvidersSpreadsheetProcessorService service;

    @GetMapping("/{scenario}")
    public ResponseEntity<Float> getEmployeesMonthlyAmount(@PathVariable int scenario) throws EmployeeException {
        float employeesMonthlyAmounts = service.sumEmployeesMonthlyAmounts(scenario);
        return ResponseEntity.ok(employeesMonthlyAmounts);
    }
}
