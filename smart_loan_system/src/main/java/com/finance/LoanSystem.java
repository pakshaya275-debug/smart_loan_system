package com.finance;

import java.util.ArrayList;
import java.util.List;

class Customer {    
    String name; int age; String govId; double monthlyIncome;    
    public Customer(String name, int age, String govId, double monthlyIncome) {        
        this.name = name; this.age = age; this.govId = govId;         
        this.monthlyIncome = monthlyIncome;    
    }
}

class LoanApplication {    
    double requestedAmount; double existingDebts;    
    public LoanApplication(double requestedAmount, double existingDebts) {        
        this.requestedAmount = requestedAmount; this.existingDebts = existingDebts;    
    }
}

class CreditAssessment {    
    int creditScore;    
    public CreditAssessment(int creditScore) { this.creditScore = creditScore; }
}

public class LoanSystem {    
    public static String evaluateLoanRisk(Customer c, LoanApplication l, CreditAssessment a) {        
        List<String> rejectReasons = new ArrayList<>();                
        if (c.age < 21) rejectReasons.add("Below minimum age");        
        if (c.govId == null || c.govId.trim().isEmpty()) rejectReasons.add("Invalid ID");        
        if (c.monthlyIncome < 3000) rejectReasons.add("Income too low");                
        
        double maxLoan = c.monthlyIncome * 12 * 0.45;        
        if (l.requestedAmount > maxLoan) rejectReasons.add("Loan exceeds max limit");        
        if (a.creditScore < 600) rejectReasons.add("Credit score too low");                
        
        double dti = ((l.existingDebts + (l.requestedAmount * 0.05)) / c.monthlyIncome) * 100;        
        
        if (!rejectReasons.isEmpty())             
            return "REJECTED: " + String.join(" | ", rejectReasons) + " | Max Permissible Amount: " + maxLoan;        
        if (a.creditScore >= 750 && dti < 30)             
            return "APPROVED (Low Risk) | Max Permissible Amount: " + maxLoan;        
        if (dti <= 50)             
            return "APPROVED (Conditional - Medium Risk) | Max Permissible Amount: " + maxLoan;        
        return "REJECTED: DTI too high";    
    }
}
