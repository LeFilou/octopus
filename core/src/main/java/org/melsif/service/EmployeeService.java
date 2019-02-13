package org.melsif.service;

import org.melsif.model.Department;
import org.melsif.model.Employee;
import org.melsif.model.Function;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private static List<Employee> employees;
    static {
        employees = new ArrayList<>();
        Employee employee = Employee.builder()
                .id("123456")
                .firstName("John")
                .lastName("doe")
                .email("johndoe@email.com")
                .function(Function.COMMERCIAL)
                .department(new Department(1, "Production"))
                .build();
        employees.add(employee);
    }


    public List<Employee> getAllEmployees() {
        return employees;
    }
}

