package com.shopping.model;

import java.time.LocalDateTime;
import org.springframework.beans.BeanUtils;

import com.shopping.entities.OrderStatus;
import com.shopping.entities.Orders;


public class OrdersDTO {
	
		private int orderid;
		private double amount;
		private LocalDateTime date;
		private OrderStatus orderStatus;
		private int userid;
			
	    public OrdersDTO() {
			
		}
	    
	    
		public OrdersDTO(int orderid, double amount, LocalDateTime date, OrderStatus orderStatus, int userid) {
			super();
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
			return "OrdersDTO [orderid=" + orderid + ", amount=" + amount + ", date=" + date + ", orderStatus="
					+ orderStatus + ", userid=" + userid + "]";
		}


		public static OrdersDTO fromEntity(Orders order) {
			OrdersDTO dto = new OrdersDTO();
			BeanUtils.copyProperties(order, dto);
			return dto;
		}
		
		public static Orders toEntity(OrdersDTO dto){
			Orders order = new Orders();
			BeanUtils.copyProperties(dto, order);
			return order;
		}
	

}
