package com.sunglowsys.service.serviceImpl;

import com.sunglowsys.domain.Employee;
import com.sunglowsys.repository.EmployeeRespository;
import com.sunglowsys.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRespository employeeRespository;

    public EmployeeServiceImpl(EmployeeRespository employeeRespository) {
        this.employeeRespository = employeeRespository;
    }

    @Override
    public  Employee save(Employee employee) {
        return  employeeRespository.save (employee);
    }

    @Override
    public Employee update(Employee employee, Long id) {
        return employeeRespository.save (employee);
    }

    @Override
    public Page<Employee> getAll(Pageable pageable) {
        return employeeRespository.findAll (pageable);
    }

    @Override
    public Optional<Employee> getOne(Long id) {
        return employeeRespository.findById (id);
    }

    @Override
    public void delete(Long id) {
        employeeRespository.deleteById (id);
    }
}
