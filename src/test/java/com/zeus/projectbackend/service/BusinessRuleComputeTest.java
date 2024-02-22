package com.zeus.projectbackend.service;

import com.zeus.projectbackend.service.impl.BusinessRuleComputeImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BusinessRuleComputeTest {

    @InjectMocks
    private BusinessRuleComputeImpl businessRuleCompute;

    @Test
    void computeAnnualSalary(){
        int response = businessRuleCompute.computeAnnualSalary(320800);
        Assertions.assertEquals(response,3849600);
    }
}
