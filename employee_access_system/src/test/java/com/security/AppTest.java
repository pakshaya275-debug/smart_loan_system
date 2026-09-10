package com.security;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void testEligibleEmployee() {
        Employee emp = new Employee("EMP10", "Akshaya P", 24, "IT", "Active", 4, true);
        assertTrue(emp.checkAccessEligibility(3).contains("Eligible"));
    }

    @Test
    public void testMultipleFailures() {
        // Underage, wrong department, inactive, and invalid ID all at once
        Employee emp = new Employee("EMP20", "Test User", 18, "Sales", "Terminated", 3, false);
        String result = emp.checkAccessEligibility(3);
        
        assertTrue(result.contains("Underage"));
        assertTrue(result.contains("Unauthorized Department"));
        assertTrue(result.contains("Inactive status"));
        assertTrue(result.contains("valid Employee ID"));
    }
}
