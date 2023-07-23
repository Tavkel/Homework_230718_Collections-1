package com.example.homework_230718_collections1.services.interrfaces;

import com.example.homework_230718_collections1.models.Department;
import com.example.homework_230718_collections1.models.Employee;

public interface DepartmentService {
    Department[] getAllDepartments();
    Department getDepartmentById(int id);
    Employee[] getEmployeesByDepartment(int id);
    boolean updateDepartment(Department department);
    int createDepartment(Department department);
}
