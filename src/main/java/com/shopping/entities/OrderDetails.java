package com.shopping.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orderdetails")
public class OrderDetails {
	@GeneratedValue(strategy = GenerationType.IDENTITY)        	 
	@Id
	private int detailid;
	private double price;
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name="orderid",nullable = false)
	private Orders currentOrder;
	
	@ManyToOne
	@JoinColumn(name="productid",nullable = false)
	private Products selectedProduct;
	
	
	public OrderDetails(){
		
	}
	public OrderDetails(int detailid, double price) {
		this.detailid = detailid;
	
		this.price = price;
	}
	
	public OrderDetails(double price, int quantity, Orders currentOrder, Products selectedProduct) {
		
		this.price = price;
		this.quantity = quantity;
		this.currentOrder = currentOrder;
		this.selectedProduct = selectedProduct;
	}
	public int getDetailid() {
		return detailid;
	}
	public void setDetailid(int detailid) {
		this.detailid = detailid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Orders getCurrentOrder() {
		return currentOrder;
	}
	public void setCurrentOrder(Orders currentOrder) {
		this.currentOrder = currentOrder;
	}
	public Products getSelectedProduct() {
		return selectedProduct;
	}
	public void setSelectedProduct(Products selectedProduct) {
		this.selectedProduct = selectedProduct;
	}
	@Override
	public String toString() {
		return "OrderDetails [detailid=" + detailid + ", price=" + price + ", quantity=" + quantity + ", currentOrder="
				+ currentOrder + ", selectedProduct=" + selectedProduct + "]";
	}
	
	
}
