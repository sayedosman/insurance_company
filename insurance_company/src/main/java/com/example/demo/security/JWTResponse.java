package com.example.demo.security;

public class JWTResponse {
	
	private String authenticationToken ;
	private String username ;
	private String type;
	
	
	
	public JWTResponse(String authenticationToken, String username,String type) {
		
		this.authenticationToken = authenticationToken;
		this.username = username;
		this.type=type;
	}


	public JWTResponse() {
		
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getAuthenticationToken() {
		return authenticationToken;
	}


	public void setAuthenticationToken(String authenticationToken) {
		this.authenticationToken = authenticationToken;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	
	
	

}
