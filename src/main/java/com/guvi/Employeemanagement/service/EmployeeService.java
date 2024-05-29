package com.guvi.Employeemanagement.service;

import com.guvi.Employeemanagement.entity.Employee;
import com.guvi.Employeemanagement.exception.ResourceNotFoundException;
import com.guvi.Employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }


    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    public Employee updateEmployee(Long id, @org.jetbrains.annotations.NotNull Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException("Employee not found with id: " + id);
                });

        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());

        return employeeRepository.save(employee);
    }


    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException("Employee not found with id: " + id);
                });
        employeeRepository.delete(employee);
    }
}


