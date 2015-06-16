package com.terry.domain;



public class User {

	private Long id;

	private Integer version;

	private String email;

	private boolean deleted = false;

	private String password;

	private String role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

//	@Override
//	public Map<String, String> validateEntity() {
//		Boolean isSuccess = true;
//		StringBuffer message = new StringBuffer("Validate User failed: ");
//		if (this.email == null) {
//			isSuccess = false;
//			message.append("email must be not null.");
//		}
//
//		messages.put("isSuccess", isSuccess.toString());
//		messages.put("message", message.toString());
//		return messages;
//	}
}
