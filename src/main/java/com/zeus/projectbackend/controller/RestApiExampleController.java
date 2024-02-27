package com.zeus.projectbackend.controller;

import com.zeus.projectbackend.model.Employee;
import com.zeus.projectbackend.model.Employees;
import com.zeus.projectbackend.service.IRestApiExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/zeus-project")
@CrossOrigin
public class RestApiExampleController {

    @Autowired
    private IRestApiExampleService iRestApiExampleService;

    @GetMapping("/list-all-employees")
    public ResponseEntity<?> listAllEmployees(){
        Employees employees = iRestApiExampleService.listAllEmployees();
        return ResponseEntity.ok().body(employees.getData());
    }

    @GetMapping("/get-employee-by-id/{employeeId}")
    public ResponseEntity<?> getEmployeeById(@PathVariable int employeeId){
        Employee employee = iRestApiExampleService.getEmployeeById(employeeId);
        return ResponseEntity.ok().body(employee.getData());
    }

}
