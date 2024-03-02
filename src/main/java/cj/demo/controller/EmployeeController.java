package cj.demo.controller;

import cj.demo.service.ProvidersSpreadsheetProcessorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private final ProvidersSpreadsheetProcessorService service;

    @GetMapping
    public ResponseEntity<Float> getEmployeesMonthlyAmount() {
        float employeesMonthlyAmounts = service.sumEmployeesMonthlyAmounts();
        return ResponseEntity.ok(employeesMonthlyAmounts);
    }
}
