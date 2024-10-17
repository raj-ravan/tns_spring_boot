package com.example.shopowner;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ShopOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate dob;
    private String address;
    private String shopId;
    
    
    
    
	public ShopOwner() {
		super();
	}


	public ShopOwner(int id, String name, LocalDate dob, String address, String shopId) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.shopId = shopId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getShopId() {
		return shopId;
	}


	public void setShopId(String shopId) {
		this.shopId = shopId;
	}


	@Override
	public String toString() {
		return "ShopOwner [id=" + id + ", name=" + name + ", dob=" + dob + ", address=" + address + ", shopId=" + shopId
				+ ", getId()=" + getId() + ", getName()=" + getName() + ", getDob()=" + getDob() + ", getAddress()="
				+ getAddress() + ", getShopId()=" + getShopId() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

    // Constructors, getters, setters, and toString method
    
}
