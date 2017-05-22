package com.example.inventory;

public class Inventory {
	private int id;
	private String name;
	private int qty;
	private double price;
	private double total;
	public Inventory(int id, String name, int qty, double price) {
		super();
		this.id = id;
		this.name = name;
		this.qty = qty;
		this.price = price;
		this.total = qty*price;
	}
	public Inventory(String name, int qty, double price) {
		super();
		this.name = name;
		this.qty = qty;
		this.price = price;
		this.total = qty*price;

	}
	public double getTotal() {
		return total;
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
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
