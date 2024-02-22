package com.zeus.projectbackend.model;

import lombok.Data;

import java.util.List;

@Data
public class Employees extends ApiResponse{
    private List<EmployeeData> data;
}
