package com.shopping.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="products")
public class Products {
	    @GeneratedValue(strategy = GenerationType.IDENTITY)        	 
	    @Id
	    @Column(nullable = false)
		private int productid;
	    private String productname;
	    private int categoryid;
		private String price;
		private int quantity;
		private String image;
		private String productdesc;
		private String brand;
		
		@Transient
		//@JsonIgnore
		@OneToMany(mappedBy = "selectedProduct", cascade = CascadeType.ALL, orphanRemoval = true)
		private List<OrderDetails> orderProducts = new ArrayList<>();

		
		
		public Products(){
			
		}
		public Products(int productid, String productname, int categoryid,String price,
				int quantity, String image, String productdesc, String brand) {
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
		
		public List<OrderDetails> getOrderProducts() {
			return orderProducts;
		}
		public void setOrderProducts(List<OrderDetails> orderProducts) {
			this.orderProducts = orderProducts;
		}
		@Override
		public String toString() {
			return "Products [productid=" + productid + ", productname=" + productname + ", categoryid=" + categoryid
					+ ", price=" + price + ", quantity=" + quantity + ", image=" + image + ", productdesc="
					+ productdesc + ", brand=" + brand + ", orderProducts=" + orderProducts + "]";
		}
		
		
		
}


