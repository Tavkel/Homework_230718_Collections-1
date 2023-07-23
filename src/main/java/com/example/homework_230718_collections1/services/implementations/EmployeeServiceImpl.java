package com.example.homework_230718_collections1.services.implementations;

import com.example.homework_230718_collections1.exceptions.EmployeeAlreadyExistsException;
import com.example.homework_230718_collections1.exceptions.MaxEmployeeCountReachedException;
import com.example.homework_230718_collections1.models.Employee;
import com.example.homework_230718_collections1.services.interrfaces.EmployeeService;
import com.example.homework_230718_collections1.services.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int MAX_EMPLOYEE_COUNT = 10;
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) throws NoSuchElementException {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        var check = employeeRepository.findByFirstNameAndLastNameAndMiddleName(employee.getFirstName(), employee.getLastName(), employee.getMiddleName());
        if(employeeRepository.count() >= MAX_EMPLOYEE_COUNT){
            throw new MaxEmployeeCountReachedException("Max employee count reached");
        }
        if (employeeRepository.findByFirstNameAndLastNameAndMiddleName(employee.getFirstName(), employee.getLastName(), employee.getMiddleName()).size() != 0){
            throw new EmployeeAlreadyExistsException("Employee already exists");
        }
        return employeeRepository.saveAndFlush(employee);
    }
}
