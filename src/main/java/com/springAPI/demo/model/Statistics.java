package com.springAPI.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "statistics")
public class Statistics {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no_of_employee;
	
	@Column(name = "money", nullable = false)
	private double money;

	public Statistics() {
		super();
	}

	public Statistics(double money) {
		super();
		this.money = money;
	}

	public Statistics(int no_of_employee, double money) {
		super();
		this.no_of_employee = no_of_employee;
		this.money = money;
	}

	public int getNo_of_employee() {
		return no_of_employee;
	}

	public void setNo_of_employee(int no_of_employee) {
		this.no_of_employee = no_of_employee;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
	
}
