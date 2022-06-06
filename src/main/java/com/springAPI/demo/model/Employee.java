package com.springAPI.demo.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	@Column(name = "position")
	private String position;
	
	@Column(name = "money_per_hour")
	private double moneyPerHour;
	
	@Column(name = "team")
	private int team_id;
	
	public Employee() {
		super();
	}

	public Employee(String fullName, int age, String sex, String address, String position, double moneyPerHour,
			int team_id) {
		super();
		this.fullName = fullName;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.position = position;
		this.moneyPerHour = moneyPerHour;
		this.team_id = team_id;
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

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, age, fullName, id, moneyPerHour, position, sex, team_id);
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
				&& Objects.equals(position, other.position) && Objects.equals(sex, other.sex)
				&& team_id == other.team_id;
	}
	
	
	
//	@ManyToOne
//	private Team team;
//	
//	@OneToOne
//	private Working working;
	
}
