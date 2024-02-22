package com.zeus.projectbackend.model;

import lombok.Data;

@Data
public class EmployeeData {
    private int id;
    private String employee_name;
    private int employee_salary;
    private int employee_annual_salary;
    private int employee_age;
    private String profile_image;
}
