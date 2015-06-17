package com.terry.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class User {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @NotNull
    @Size(max = 64)
    private String id;

    @Column(name = "password", nullable = false)
    @NotNull
    @Size(max = 64)
    private String password;

    public User() {
    }

    public User(final String id, final String password) {
        this.id = id;
        this.password = password;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
