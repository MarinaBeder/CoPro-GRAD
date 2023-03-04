package com.Fintech.CoPro.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.time.LocalDate;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="bank")
public class BankInfo   {
	private static final long serialVersionUID = 7321374061017039662L;
	


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
	private String username;
	///private String email;
	//@JsonIgnore
	private String password;
    private String phone;
    private LocalDate birthday;  
	private String country;
	private String city;
	private String address;
	private String gender;
	private String verficationCode;
	//private boolean enable = false;
	
	private long nationalId;
	private long numberCardBank;
	private long endDateCard;
	private long passwordCardBank;
	private long requestPasswordCardBank;

	
	
	public long getRequestPasswordCardBank() {
		return requestPasswordCardBank;
	}
	public void setRequestPasswordCardBank(long requestPasswordCardBank) {
		this.requestPasswordCardBank = requestPasswordCardBank;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getVerficationCode() {
		return verficationCode;
	}
	public void setVerficationCode(String verficationCode) {
		this.verficationCode = verficationCode;
	}
	public long getNationalId() {
		return nationalId;
	}
	public void setNationalId(long nationalId) {
		this.nationalId = nationalId;
	}
	public long getNumberCardBank() {
		return numberCardBank;
	}
	public void setNumberCardBank(long numberCardBank) {
		this.numberCardBank = numberCardBank;
	}

	public void setEndDateCard(long endDateCard) {
		this.endDateCard = endDateCard;
	}

	public long getEndDateCard() {
		return endDateCard;
	}
	public long getPasswordCardBank() {
		return passwordCardBank;
	}
	public void setPasswordCardBank(long passwordCardBank) {
		this.passwordCardBank = passwordCardBank;
	}

	



	

}
