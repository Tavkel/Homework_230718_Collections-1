package com.example.homework_230718_collections1.controllers;

import com.example.homework_230718_collections1.models.Employee;
import com.example.homework_230718_collections1.services.interrfaces.EmployeeService;
import com.example.homework_230718_collections1.services.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/employee")
    public ResponseEntity<Employee> getEmployeeById(@RequestParam int id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        if (employee.getId() == 0) {
            var result = employeeService.createEmployee(employee);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            var result = employeeService.updateEmployee(employee);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
}
