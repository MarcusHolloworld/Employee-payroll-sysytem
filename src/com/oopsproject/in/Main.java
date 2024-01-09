package com.oopsproject.in;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
	    PayRollSystem payRollSystem = new PayRollSystem();

	    FullTimeEmployee emp1 = new FullTimeEmployee("Rohit" , 1001 , 95000);
	    FullTimeEmployee emp2 = new FullTimeEmployee("Diya" , 1002 ,15000);
	    PartTimeEmployee emp3 = new PartTimeEmployee("Rakesh" , 0001 , 250 , 17);
	    PartTimeEmployee emp4 = new PartTimeEmployee("Riya" , 0002 , 500 , 20);

	    payRollSystem.addEmployee(emp1);
	    payRollSystem.addEmployee(emp2);
	    payRollSystem.addEmployee(emp3);
	    payRollSystem.addEmployee(emp4);

	    System.out.println("\n----:Initial Employee details:---- \n");
	    payRollSystem.displayEmployee();

	    System.out.println("\n----Remove Employee----\n");
	    payRollSystem.removeEmployee(2);
	    payRollSystem.displayEmployee();
    }
}

abstract class Employee {

	private String name;

	private int id;

	public Employee(String name , int id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public abstract double calculateSalary();

	@Override
	public String toString() {
		return "Employee[name=" + name + " , id=" + id + " , salary=" + calculateSalary() + "]";
	}
}

class FullTimeEmployee extends Employee{

	private double monthlySalary;

	public FullTimeEmployee(String name , int id , double monthlySalary) {
		super(name , id );
		this.monthlySalary = monthlySalary;
	}

	@Override
	public double calculateSalary() {
		return monthlySalary;
	}
}

class PartTimeEmployee extends Employee {

	private double hourlyRate;

	private int hoursWorked;

	public PartTimeEmployee (String name , int id , double hourlyRate , int hoursWorked ) {
		super(name , id);
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;
	}

	@Override
	public double calculateSalary() {
		return hourlyRate * hoursWorked;
	}
}

class PayRollSystem {

	private ArrayList<Employee> employeeList;

	public PayRollSystem() {
		employeeList = new ArrayList<>();
	}

	public void addEmployee(Employee employee) {
		employeeList.add(employee);
	}

	public void removeEmployee(int id) {
		Employee employeeToRemove = null;
		for (Employee employee : employeeList) {
			if (employee.getId() == id) {
				employeeToRemove = employee;
				break;
			}
		}

		if (employeeToRemove != null) {
			employeeList.remove(employeeToRemove);
		} else {
			System.out.println("Employee ID is not matching with any employee.");
		}
	}

	public void displayEmployee() {
		for (Employee employee : employeeList) {
			System.out.println(employee);
		}
	}
}
