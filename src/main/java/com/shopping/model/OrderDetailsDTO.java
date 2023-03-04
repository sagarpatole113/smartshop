package com.shopping.model;



import org.springframework.beans.BeanUtils;
import com.shopping.entities.OrderDetails;

public class OrderDetailsDTO {
	private int detailid;
	private int orderid;
	private String price;
	private int productid;
	OrderDetailsDTO(){
		
	}
	public OrderDetailsDTO(int detailid, int orderid, String price, int productid) {
		this.detailid = detailid;
		this.orderid = orderid;
		this.price = price;
		this.productid = productid;
	}
	public int getDetailid() {
		return detailid;
	}
	public void setDetailid(int detailid) {
		this.detailid = detailid;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	@Override
	public String toString() {
		return "OrderDetails [detailid=" + detailid + ", orderid=" + orderid + ", price=" + price + ", productid="
				+ productid + "]";
	}
	public static OrderDetailsDTO fromEntity(OrderDetails orderdetail) {
		OrderDetailsDTO dto = new OrderDetailsDTO();
		BeanUtils.copyProperties(orderdetail, dto);
		return dto;
	}
	
	public static OrderDetails toEntity(OrderDetailsDTO dto){
		OrderDetails orderdetail = new OrderDetails();
		BeanUtils.copyProperties(dto, orderdetail);
		return orderdetail;
	}

}
