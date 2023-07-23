package com.example.homework_230718_collections1.services.interrfaces;

import com.example.homework_230718_collections1.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    Employee updateEmployee(Employee employee);
    Employee createEmployee(Employee employee);
}
