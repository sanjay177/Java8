package com.pt;

import java.time.LocalDate;

public class Employee {

	String name;
	double salary;
	String department;
	Double experience;
	String address;
	LocalDate hireDate;
		
	
	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public Employee(String name, double salary , String department, Double exp,String address) {
	this.name=name;
	this.salary=salary;
	this.department=department;
	this.experience=exp;
	this.address=address;
	}
	
	public Employee(String name, double salary , String department, Double exp,String address,LocalDate hireDate) {
		this.name=name;
		this.salary=salary;
		this.department=department;
		this.experience=exp;
		this.address=address;
		this.hireDate=hireDate;
		}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getExperience() {
		return experience;
	}
	public void setExperience(double experience) {
		this.experience = experience;
	}
	
	@Override
	public String toString() {
		return "Name "+name+" Deparatment "+department+" Experience "+experience+" Salary "+salary;
	}
}
