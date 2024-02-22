package com.zeus.projectbackend.service.impl;

import com.zeus.projectbackend.service.IBusinessRuleCompute;
import org.springframework.stereotype.Service;

@Service
public class BusinessRuleComputeImpl implements IBusinessRuleCompute {
    @Override
    public int computeAnnualSalary(int salary) {
        return salary * 12;
    }
}
