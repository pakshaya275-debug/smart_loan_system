package com.security;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     AUTOMATED EMPLOYEE ACCESS ELIGIBILITY SYSTEM ");
        System.out.println("==================================================");

        List<Employee> employeePool = new ArrayList<>();
        employeePool.add(new Employee("EMP01", "Akshaya P", 24, "IT", "Active", 4, true));
        employeePool.add(new Employee("EMP02", "Suresh Kumar", 19, "Marketing", "Terminated", 1, false));
        employeePool.add(new Employee("EMP03", "Meena R", 22, "HR", "Active", 2, true));

        for (Employee emp : employeePool) {
            System.out.println("Processing Employee: " + emp.getName());
            System.out.println("Status Result...   : " + emp.checkAccessEligibility(3));
            System.out.println("--------------------------------------------------");
        }
    }
}
