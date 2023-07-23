package com.example.homework_230718_collections1.services.repository;

import com.example.homework_230718_collections1.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
