package com.app.auth.config;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	
	private final String jwttoken;
	private final String usertype;
	private final Long sid;
	private final String name;

	public JwtResponse(String jwttoken, String usertype,Long sid, String name) {
		this.jwttoken = jwttoken;
		this.usertype = usertype;
		this.sid = sid;
		this.name = name;
	}

	public String getToken() {
		return this.jwttoken;
	}
	
	public String getUsertype() {
		return this.usertype;
	}
	
	public Long getSid() {
		return this.sid;
	}
	public String getName() {
		return this.name;
	}
}