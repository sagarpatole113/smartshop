package com.shopping.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="orders")
public class Orders{
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)        	 
	@Id
	private int orderid;
	
	private double amount;
	
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private LocalDateTime date;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	private int userid;
	
	@ManyToOne
	@JoinColumn(name="userid",nullable = false,insertable=false, updatable=false)
	private User userId;
	
	public Orders() {
		
	}
	
	
    public Orders(double amount, LocalDateTime date, OrderStatus orderStatus, int userid) {
		this.amount = amount;
		this.date = date;
		this.orderStatus = orderStatus;
		this.userid = userid;
	}







	public Orders(int orderid, double amount, LocalDateTime date, OrderStatus orderStatus, int userid) {
		this.orderid = orderid;
		this.amount = amount;
		this.date = date;
		this.orderStatus = orderStatus;
		this.userid = userid;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Orders [orderid=" + orderid + ", amount=" + amount + ", date=" + date + ", orderStatus=" + orderStatus
				+ ", userid=" + userid + "]";
	}
		
	
}