package com.shopping.model;

import org.springframework.beans.BeanUtils;

import com.shopping.entities.Cart;

public class ShowCartDTO {
	private int cartid;
	private String price;
	private String quantity;
	private int userid;
	private int productid;
	
	private String productname;
	private String image;
	private String productdesc;
	private String brand;
	
	public ShowCartDTO() {
	}

	public ShowCartDTO(int cartid, String price, String quantity, int userid, int productid, String productname,
			String image, String productdesc, String brand) {
		super();
		this.cartid = cartid;
		this.price = price;
		this.quantity = quantity;
		this.userid = userid;
		this.productid = productid;
		this.productname = productname;
		this.image = image;
		this.productdesc = productdesc;
		this.brand = brand;
	}

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getProductdesc() {
		return productdesc;
	}

	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "ShowCartDTO [cartid=" + cartid + ", price=" + price + ", quantity=" + quantity + ", userid=" + userid
				+ ", productid=" + productid + ", productname=" + productname + ", image=" + image + ", productdesc="
				+ productdesc + ", brand=" + brand + "]";
	}
	
	public static ShowCartDTO fromEntity(Cart entity) {
		ShowCartDTO dto = new ShowCartDTO();
		BeanUtils.copyProperties(entity, dto);
		dto.setProductname(entity.getProductId().getProductname());
		dto.setImage(entity.getProductId().getImage());
		dto.setProductdesc(entity.getProductId().getProductdesc());
		dto.setBrand(entity.getProductId().getBrand());
		return dto;
	}
	
}
