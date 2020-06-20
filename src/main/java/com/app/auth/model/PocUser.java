package com.app.auth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity()
@NamedQuery(name="PocUser.findByUserName", query="Select s from PocUser s where lower(s.username) =  lower(?1)")
@NamedQuery(name="PocUser.findByUserNameUserType", query="Select s from PocUser s where lower(s.username) =  lower(?1) and lower(s.usertype) =  lower(?2)")
@Table(name = "pocuser")
public class PocUser {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "USERTYPE")
	private String usertype;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	@Override
	public String toString() {
		return "PocUser [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", usertype=" + usertype + "]";
	}


	
	
	
	
}
