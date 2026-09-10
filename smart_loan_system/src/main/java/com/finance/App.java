package com.finance;

public class App {    
    public static void main(String[] args) {        
        System.out.println("==================================================");        
        System.out.println("     AUTOMATED SMART LOAN RISK EVALUATION SYSTEM  ");        
        System.out.println("==================================================");        
        Customer customer = new Customer("Akshaya P", 24, "GOV-112", 6000.0);        
        LoanApplication loan = new LoanApplication(15000.0, 500.0);        
        CreditAssessment assessment = new CreditAssessment(780);        
        
        System.out.println("Evaluating Loan System Records for: " + customer.name);        
        System.out.println("Risk Output Status Result Matrix: " +                           
                           LoanSystem.evaluateLoanRisk(customer, loan, assessment));        
        System.out.println("==================================================");    
    }
}
