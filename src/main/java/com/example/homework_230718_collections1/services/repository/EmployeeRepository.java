package com.example.homework_230718_collections1.services.repository;

import com.example.homework_230718_collections1.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByFirstNameAndLastNameAndMiddleName(String firstName, String lastName, String middleName);
}
