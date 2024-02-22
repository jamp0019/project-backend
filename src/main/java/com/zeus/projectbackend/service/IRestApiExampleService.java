package com.zeus.projectbackend.service;

import com.zeus.projectbackend.model.Employee;
import com.zeus.projectbackend.model.Employees;

public interface IRestApiExampleService {
    Employees listAllEmployees();
    Employee getEmployeeById(int employeeId);
}
