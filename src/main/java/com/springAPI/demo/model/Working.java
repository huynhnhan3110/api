package com.springAPI.demo.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "working")
public class Working {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no_of_employee;
	
	@Column(name = "number_hour", nullable = false)
	private String numberHour;

	public Working() {
	}

	public Working(String numberHour) {
		this.numberHour = numberHour;
	}

	public Working(long no_of_employee, String numberHour) {
		this.no_of_employee = no_of_employee;
		this.numberHour = numberHour;
	}

	public long getNo_of_employee() {
		return no_of_employee;
	}

	public void setNo_of_employee(long no_of_employee) {
		this.no_of_employee = no_of_employee;
	}

	public String getNumberHour() {
		return numberHour;
	}

	public void setNumberHour(String numberHour) {
		this.numberHour = numberHour;
	}

	@Override
	public int hashCode() {
		return Objects.hash(no_of_employee, numberHour);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Working other = (Working) obj;
		return no_of_employee == other.no_of_employee && Objects.equals(numberHour, other.numberHour);
	}
	
	
}
