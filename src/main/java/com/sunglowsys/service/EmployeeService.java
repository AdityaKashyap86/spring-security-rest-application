package com.sunglowsys.service;

import com.sunglowsys.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface EmployeeService {

    Employee save(Employee employee);

    Employee update(Employee employee, Long id);

    Page<Employee> getAll(Pageable pageable);

    Optional<Employee> getOne(Long id);

    void delete(Long id);

}
