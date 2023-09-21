package com.employedata.service.impl;


import com.employedata.entity.Employee;
import com.employedata.payload.EmployeeDTO;
import com.employedata.repository.EmployeeRepository;
import com.employedata.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);

        if (employeeRepository.existsByEmail(employee.getEmail())) {
            throw new IllegalArgumentException("Email address is already in use.");
        }

        try {
            Employee newEmployee = employeeRepository.save(employee);
            return modelMapper.map(newEmployee, EmployeeDTO.class);
        } catch (DataIntegrityViolationException e) {
            // Handle database integrity violation (e.g., unique constraint violation)
            throw new IllegalArgumentException("Error occurred while saving the employee.");
        }
    }
}
