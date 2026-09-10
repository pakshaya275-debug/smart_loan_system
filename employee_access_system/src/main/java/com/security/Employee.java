package com.security;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String employeeId;
    private String name;
    private int age;
    private String department;
    private String employmentType; // "Active" or "Terminated"
    private int securityClearanceLevel; // 1 to 5
    private boolean isIdValid;

    public Employee(String employeeId, String name, int age, String department, String employmentType, int securityClearanceLevel, boolean isIdValid) {
        this.employeeId = employeeId;
        this.name = name;
        this.age = age;
        this.department = department;
        this.employmentType = employmentType;
        this.securityClearanceLevel = securityClearanceLevel;
        this.isIdValid = isIdValid;
    }

    public String checkAccessEligibility(int requiredLevel) {
        List<String> reasons = new ArrayList<>();

        // 1. Age constraint check
        if (age < 21) {
            reasons.add("Underage (Must be at least 21 years old)");
        }
        // 2. Department check
        List<String> validDeps = List.of("IT", "HR", "Finance", "Administration");
        if (!validDeps.contains(department)) {
            reasons.add("Unauthorized Department (" + department + ")");
        }
        // 3. Active status check
        if (!"Active".equalsIgnoreCase(employmentType)) {
            reasons.add("Inactive status");
        }
        // 4. ID asset verification check
        if (!isIdValid) {
            reasons.add("Does not possess a valid Employee ID");
        }
        // 5. Security level check
        if (securityClearanceLevel < requiredLevel) {
            reasons.add("Insufficient clearance (Has level " + securityClearanceLevel + " but requires level " + requiredLevel + ")");
        }

        // Return decision based on error checking logs
        if (!reasons.isEmpty()) {
            return "Not Eligible: " + String.join(", ", reasons) + ".";
        }
        
        if ("Temporary".equalsIgnoreCase(employmentType) || securityClearanceLevel == requiredLevel) {
            return "Conditionally Eligible: Subject to verification checks.";
        }

        return "Eligible: Criteria met successfully.";
    }

    public String getName() { return name; }
}
