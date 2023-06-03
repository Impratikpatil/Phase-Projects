package com.camera_rental_application.cameras;

import java.util.Objects;

public class Cameras {
	private int id;
	private String brand;
	private String model;
	private double price;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Cameras(int id, String brand, String model, double price, String status) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Cameras [id=" + id + ", brand=" + brand + ", model=" + model + ", price=" + price + ", status=" + status
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(brand, id, model, price, status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cameras other = (Cameras) obj;
		return Objects.equals(brand, other.brand) && id == other.id && Objects.equals(model, other.model)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(status, other.status);
	}
	public Cameras() {
	}
	
	
}
