package bltn.uc3m.tiw.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;
	
	private String email;
	private String password;
	private String forename;
	private String surname;
	private String city;
	private boolean admin;
	
	public Integer getUserID() {
		return user_id;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getForename() {
		return forename;
	}
	public String getSurname() {
		return surname;
	}
	public String getCity() {
		return city;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setUserID(Integer userID) {
		this.user_id = userID;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setForename(String forename) {
		this.forename = forename;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}

/**
package es.uc3m.tiw.domains;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.transaction.Transactional;


/**
@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long iduser;

	private String name;

	private String surename;
	
	@OneToMany (mappedBy="user",
				cascade=CascadeType.ALL,
				fetch = FetchType.EAGER)
	//@JoinColumn(name="usuarioId")
	Set<Address> address;	

	public User() {
	}

	public Long getIduser() {
		return this.iduser;
	}

	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurename() {
		return this.surename;
	}

	public void setSurename(String surename) {
		this.surename = surename;
	}

}
**/