package com.shopping.model;

import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;

import com.shopping.entities.Products;

public class ProductInDTO {
	private int productid;
    private String productname;
    private int categoryid;
	private String price;
	private int quantity;
	private MultipartFile image;
	private String productdesc;
	private String brand;
	public ProductInDTO() {
		
	}
	
	public ProductInDTO(int productid, String productname, int categoryid, String price,
		int quantity, MultipartFile image, String productdesc, String brand) {
		this.productid = productid;
		this.productname = productname;
		this.categoryid = categoryid;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
		this.productdesc = productdesc;
		this.brand = brand;
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
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
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
		return "ProductInDTO [productid=" + productid + ", productname=" + productname + ", categoryid=" + categoryid
				+ ", price=" + price + ", quantity=" + quantity + ", image="
				+ image + ", productdesc=" + productdesc + ", brand=" + brand + "]";
	}
	public static Products toEntity(ProductInDTO dto) {
		Products entity = new Products();
		BeanUtils.copyProperties(dto, entity, "image");
		return entity;
	}
}
