package bltn.uc3m.tiw.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity 
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer userID;
	
	@Size(min = 2, max=254)
	private String email;
	@Size(min = 2, max=32)
	private String password;
	@Size(min = 2, max=40)
	private String forename;
	@Size(min = 2, max=70)
	private String surname;
	@Size(min = 2, max=40)
	private String city;
	private boolean admin;
	
	public Integer getUserID() {
		return userID;
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
		this.userID = userID;
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