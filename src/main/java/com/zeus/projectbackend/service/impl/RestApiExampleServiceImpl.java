package com.zeus.projectbackend.service.impl;

import com.zeus.projectbackend.client.IRestApiExampleClient;
import com.zeus.projectbackend.exception.BadRequestException;
import com.zeus.projectbackend.exception.InternalServerErrorCustom;
import com.zeus.projectbackend.model.Employee;
import com.zeus.projectbackend.model.Employees;
import com.zeus.projectbackend.service.IBusinessRuleCompute;
import com.zeus.projectbackend.service.IRestApiExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RestApiExampleServiceImpl implements IRestApiExampleService {

    @Autowired
    private IRestApiExampleClient IRestApiExampleClient;

    @Autowired
    private IBusinessRuleCompute businessRuleCompute;

    @Override
    public Employees listAllEmployees() {

        Employees employees;
        try{
            employees = IRestApiExampleClient.listAllEmployees();
            if(employees.getData()==null){
                log.error("Employee list is null");
                throw new BadRequestException("Employee list is null");
            }
            employees.getData().forEach(employeeData -> {
                employeeData.setEmployee_annual_salary(businessRuleCompute.computeAnnualSalary(employeeData.getEmployee_salary()));
            });
        } catch (Exception ex){
            log.info("Message error: {}", ex.getMessage());
            throw  new InternalServerErrorCustom(ex.getMessage());
        }
        log.info("Employees: {}", employees.getData());
        return employees;

    }
    @Override
    public Employee getEmployeeById(int employeeId) {

        Employee employee;
        try {
            employee = IRestApiExampleClient.getEmployeeById(employeeId);
            if(employee.getData()==null){
                log.error("Employee not exist");
                throw new BadRequestException("Employee not exist");
            }
            employee.getData().setEmployee_annual_salary(businessRuleCompute.computeAnnualSalary(employee.getData().getEmployee_salary()));
        } catch (Exception ex){
            log.info("Message error: {}", ex.getMessage());
            throw  new InternalServerErrorCustom(ex.getMessage());
        }
        log.info("employee: {}", employee.getData());
        return employee;

    }
}
