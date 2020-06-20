package com.app.auth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity()
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "CNAME")
	private String cname;
	
	@Column(name = "FEE")
	private String fee;
	
	@Column(name = "DURATION")
	private String duration;
	
	@Column(name = "SDATE")
	private String sdate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", cname=" + cname + ", fee=" + fee + ", duration=" + duration + ", sdate=" + sdate
				+ "]";
	}

	
	
	
	

	
	
	
	
	
	
	
	
	
}
