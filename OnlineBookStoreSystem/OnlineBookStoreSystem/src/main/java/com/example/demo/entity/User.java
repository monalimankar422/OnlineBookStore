package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name ="User_table")
public class User {
	
	@Id // define primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increments
	public int userId;
	
	@NotEmpty
	@Size(min = 2, message = "Fullname contain atleast 2 characters")
	public String firstName;
	
	@NotEmpty
	@Size(min = 2, message = "lastname contain atleast 2 characters")
	public String lastName;
	
    @NotEmpty
    @Column(name = "email_id", unique = true, length = 30)
	@Email(message = "Email  is not valid!")
	public String emailId;
    
    @Column(name = "password", length = 20)
	@NotEmpty
	@Size(min = 8, message = "Password length must be 8 and contain uppercase,lowercase,digits")
	//@Pattern(regexp = "(?=.\\d)(?=.[a-z])(?=.*[A-Z]).{8,}")
    public String password;
    
    @Column(name="phone_number" ,unique=true)
	@NotEmpty
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Phone number must start with a digit between 6 and 9 and contain exactly 10 digits")
	@Size(min=10 ,max=10, message="phoneNumber must contain  10 digits")
    public String phone;
    
    @NotEmpty
    public String address;
    
	public User() {
		super();
	}

	public User(String firstName, String lastName, String emailId, String password, String phone, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.phone = phone;
		this.address = address;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", password=" + password + ", phone=" + phone + ", address=" + address + "]";
	}
    
	

}
