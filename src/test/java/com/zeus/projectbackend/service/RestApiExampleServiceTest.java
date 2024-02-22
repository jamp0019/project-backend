package com.zeus.projectbackend.service;

import com.zeus.projectbackend.client.IRestApiExampleClient;
import com.zeus.projectbackend.exception.InternalServerErrorCustom;
import com.zeus.projectbackend.model.Employee;
import com.zeus.projectbackend.model.Employees;
import com.zeus.projectbackend.model.LoadData;
import com.zeus.projectbackend.service.impl.RestApiExampleServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RestApiExampleServiceTest {

    @InjectMocks
    private RestApiExampleServiceImpl restApiExampleService;

    @Mock
    private IRestApiExampleClient iRestApiExampleClient;

    @Mock
    private IBusinessRuleCompute iBusinessRuleCompute;

    private Employees employees;

    private Employee employee;

    private Employees NullEmployees;

    private Employee NullEmployee;

    @BeforeEach
    void before() {
        LoadData loadData = new LoadData();
        employees = loadData.buildEmployees();
        employee = loadData.buildEmployee();
        NullEmployees = loadData.buildEmployeesNull();
        NullEmployee = loadData.buildEmployeeNull();
    }

    @Test
    void listAllEmployeesSuccessful(){
        when(iRestApiExampleClient.listAllEmployees()).thenReturn(employees);
        Employees response = restApiExampleService.listAllEmployees();
        Assertions.assertNotNull(response);
    }

    @Test
    void getEmployeeByIdSuccessful(){
        when(iRestApiExampleClient.getEmployeeById(1)).thenReturn(employee);
        Employee response = restApiExampleService.getEmployeeById(1);
        Assertions.assertNotNull(response);
    }

    @Test
    void listAllEmployeesWithNull(){
        when(iRestApiExampleClient.listAllEmployees()).thenReturn(NullEmployees);
        assertThrows(InternalServerErrorCustom.class, () ->{
            restApiExampleService.listAllEmployees();
        });
    }

    @Test
    void getEmployeeByIdWithNull(){
        when(iRestApiExampleClient.getEmployeeById(1)).thenReturn(NullEmployee);
        assertThrows(InternalServerErrorCustom.class, () ->{
            restApiExampleService.getEmployeeById(1);
        });
    }

}
