package com.bujair.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addressID;
	private String hoNo;
	private String street;
	private String city;
	private String state;
	private String pin;
	private String landLine;
	private String country;
	
	public Long getAddressID() {
		return addressID;
	}
	public void setAddressID(Long id) {
		this.addressID = id;
	}
	public String getHoNo() {
		return hoNo;
	}
	public void setHoNo(String hoNo) {
		this.hoNo = hoNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getLandLine() {
		return landLine;
	}
	public void setLandLine(String landLine) {
		this.landLine = landLine;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = (country==null?"India":country);
	}
	
	
	
}
