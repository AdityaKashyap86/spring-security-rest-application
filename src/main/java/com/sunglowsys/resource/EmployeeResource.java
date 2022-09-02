package com.sunglowsys.resource;

import com.sunglowsys.domain.Employee;
import com.sunglowsys.service.EmployeeService;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeResource {

    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee result = employeeService.save (employee);
        return ResponseEntity
                .status (HttpStatus.OK)
                .body (result);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, Long id) {
        Employee result = employeeService.update (employee, id);
        return ResponseEntity
                .status (HttpStatus.OK)
                .body (result);
    }

    @GetMapping("/employees")
    public ResponseEntity<Page<Employee>> getAllEmployees(Pageable pageable) {
        Page<Employee> result = employeeService.getAll (PageRequest.of (1,5));
        return ResponseEntity
                .status (HttpStatus.OK)
                .body (result);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Optional<Employee>> getOneEmployee(@PathVariable Long id) {
        Optional<Employee> result = employeeService.getOne (id);
        return ResponseEntity
                .status (HttpStatus.OK)
                .body (result);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteOneEmployee(@PathVariable Long id) {
        employeeService.delete (id);
       return ResponseEntity
                .status (HttpStatus.OK)
                .build ();
    }

}
