package com.springAPI.demo.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private long id;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "sex")
	private String sex;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "start_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
	@Column(name = "position", nullable = true)
	private String position;
	
	@Column(name = "money_per_hour")
	private double moneyPerHour;


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Team team;
	
	

	
	 
	public Employee() {
		super();
	}

	

	public Employee(String fullName, int age, String sex, String address, String phoneNumber, Date startDate, String position, double moneyPerHour,
			Team team) {
		super();
		this.fullName = fullName;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.startDate = startDate;
		this.position = position;
		this.moneyPerHour = moneyPerHour;
		this.team = team;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getMoneyPerHour() {
		return moneyPerHour;
	}

	public void setMoneyPerHour(double moneyPerHour) {
		this.moneyPerHour = moneyPerHour;
	}
	
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public void removeTeam() {
		this.team = null;
	}
	

	public Date getStartDate() {
		return startDate;
	}



	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	@Override
	public int hashCode() {
		return Objects.hash(address, age, fullName, id, moneyPerHour, phoneNumber, position, sex, startDate);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(address, other.address) && age == other.age && Objects.equals(fullName, other.fullName)
				&& id == other.id
				&& Double.doubleToLongBits(moneyPerHour) == Double.doubleToLongBits(other.moneyPerHour)
				&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(position, other.position)
				&& Objects.equals(sex, other.sex) && Objects.equals(startDate, other.startDate);
	}
}
