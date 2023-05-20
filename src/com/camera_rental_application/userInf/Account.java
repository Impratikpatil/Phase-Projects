package com.camera_rental_application.userInf;

import java.util.Objects;

public class Account {
	private String userName;
	private String password;
	private double wallet =1000;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getWallet() {
		return wallet;
	}
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	
	@Override
	public String toString() {
		return " wallet=" + wallet;
	}
	public Account(String userName, String password, Double wallet) {
		super();
		this.userName = userName;
		this.password = password;
		this.wallet = wallet;
	}
	public Account() {
	}
	@Override
	public int hashCode() {
		return Objects.hash(password, userName, wallet);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(password, other.password) && Objects.equals(userName, other.userName)
				&& Objects.equals(wallet, other.wallet);
	}
	public Account(double wallet) {
		super();
		this.wallet = wallet;
	}
	
}
