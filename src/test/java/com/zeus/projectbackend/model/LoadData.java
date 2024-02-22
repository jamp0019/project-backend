package com.zeus.projectbackend.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LoadData {

    public Employees buildEmployees(){
        Employees employees = new Employees();
        List<EmployeeData> employeeDataList = new ArrayList<>();
        EmployeeData employeeData1 = buildEmployeeData(1, "Tiger Nixon", 61, 320800);
        EmployeeData employeeData2 = buildEmployeeData(2, "Garrett Winters", 63, 170750);
        EmployeeData employeeData3 = buildEmployeeData(3, "Ashton Cox", 66, 86000);
        employeeDataList.add(employeeData1);
        employeeDataList.add(employeeData2);
        employeeDataList.add(employeeData3);
        employees.setData(employeeDataList);
        employees.setMessage("Successfully! All records has been fetched.");
        employees.setStatus("success");
        return employees;
    }

    public Employee buildEmployee(){
        Employee employee = new Employee();
        EmployeeData employeeData = buildEmployeeData(1, "Tiger Nixon", 61, 320800);
        employee.setData(employeeData);
        employee.setMessage("Successfully! All records has been fetched.");
        employee.setStatus("success");
        return employee;
    }

    public Employees buildEmployeesNull(){
        Employees employees = new Employees();
        employees.setData(null);
        employees.setMessage("Successfully! All records has been fetched.");
        employees.setStatus("success");
        return employees;
    }

    public Employee buildEmployeeNull(){
        Employee employee = new Employee();
        employee.setData(null);
        employee.setMessage("Successfully! All records has been fetched.");
        employee.setStatus("success");
        return employee;
    }

    public EmployeeData buildEmployeeData(int id, String name, int age, int salary){
        EmployeeData employeeData = new EmployeeData();
        employeeData.setId(id);
        employeeData.setEmployee_name(name);
        employeeData.setEmployee_age(age);
        employeeData.setEmployee_salary(salary);
        employeeData.setProfile_image("");
        return employeeData;
    }

}
