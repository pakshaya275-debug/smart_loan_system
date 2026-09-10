package com.finance;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {        
    @Test    
    public void testIdealLowRiskApproval() {        
        Customer c = new Customer("Ideal Customer", 35, "GOV-999", 8000.0);        
        LoanApplication l = new LoanApplication(10000.0, 200.0);        
        CreditAssessment a = new CreditAssessment(800);        
        String res = LoanSystem.evaluateLoanRisk(c, l, a);        
        assertTrue(res.contains("APPROVED"));    
    }    

    @Test    
    public void testUnderageDenial() {        
        Customer c = new Customer("Underage User", 19, "GOV-001", 5000.0);        
        LoanApplication l = new LoanApplication(5000.0, 100.0);        
        CreditAssessment a = new CreditAssessment(650);        
        String res = LoanSystem.evaluateLoanRisk(c, l, a);        
        assertTrue(res.contains("age"));    
    }    

    @Test    
    public void testBoundaryConditions() {        
        Customer c = new Customer("Boundary User", 21, "GOV-555", 3000.0);        
        LoanApplication l = new LoanApplication(5000.0, 100.0);        
        CreditAssessment a = new CreditAssessment(600);        
        String res = LoanSystem.evaluateLoanRisk(c, l, a);        
        assertFalse(res.contains("Underage"));    
    }
}
