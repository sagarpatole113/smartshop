package com.shopping.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.shopping.entities.Products;

public interface ProductService {
		List<Products> getAllProducts();
		Products addProduct(Products product);
		Products getProductById(int productid);
		List<Products> getProductByProductname(String productname);
		List<Products> getProductsByBrand(String brand);
		List<Products> getProductsByCategoryid(int categoryid);
		boolean deleteById(int productid);
		Products updateProduct(Products product);
		Products saveProduct(Products product, MultipartFile image);


}
