package com.springAPI.demo.model;

import java.util.Date;
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
	private long id;
	
//	@Column(name="employee_id")
    private long employee_id;
	
	@Column(name="date_time")
	private Date date_time;
	
	@Column(name = "number_hour")
	private int numberHour;

	public Working() {
	}

	public Working(long id, long employee_id, int numberHour, Date date_time) {
		this.id = id;
		this.employee_id = employee_id;
		this.numberHour = numberHour;
		this.date_time = date_time;
	}

	public Working(long employee_id, int numberHour, Date date_time) {
		this.employee_id = employee_id;
		this.date_time = date_time;
		this.numberHour = numberHour;
	}


	

	public Date getDate_time() {
		return date_time;
	}

	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


		

	public long getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(long employee_id) {
		this.employee_id = employee_id;
	}

	public int getNumberHour() {
		return numberHour;
	}

	public void setNumberHour(int numberHour) {
		this.numberHour = numberHour;
	}

	
	
	
}
