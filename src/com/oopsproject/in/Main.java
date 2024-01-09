package com.oopsproject.in;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
	    System.out.println("Hello world!");
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

class payRollSystem {

	private ArrayList<Employee> employeeList;

	public payRollSystem() {
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
