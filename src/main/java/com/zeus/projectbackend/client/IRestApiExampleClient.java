package com.zeus.projectbackend.client;

import com.zeus.projectbackend.model.Employee;
import com.zeus.projectbackend.model.Employees;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "rest-api-example",
        url = "${rest.api.example}")
public interface IRestApiExampleClient {
    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/employees")
    Employees listAllEmployees();

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/employee/{employeeId}")
    Employee getEmployeeById(@PathVariable("employeeId") int employeeId);
}
