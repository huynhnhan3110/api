package com.springAPI.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name ="advance")
public class Advance {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="date_time")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date date_time;
	
	@Column(name = "money")
	private double money;
	
	@Column(name = "employee_id")
	private long employee_id;
	
	public Advance() {}
	public Advance(long id, Date date_time, double money, long employee_id) {
		super();
		this.id = id;
		this.date_time = date_time;
		this.money = money;
		this.employee_id = employee_id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate_time() {
		return date_time;
	}
	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public long getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(long employee_id) {
		this.employee_id = employee_id;
	}
	
	
}
