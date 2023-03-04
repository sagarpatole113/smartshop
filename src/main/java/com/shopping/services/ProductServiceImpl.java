package com.shopping.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.shopping.dao.ProductDao;
import com.shopping.entities.Products;
import com.shopping.utils.StorageService;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {
//	@Autowired
//	private ProductService productservice;
	@Autowired
	private ProductDao productdao;
	@Autowired
	private StorageService storageService;

	

	@Override
	public List<Products> getAllProducts() {
		List<Products> list=productdao.findAll();
		return list;
	}

	@Override
	public Products addProduct(Products product) {
		return productdao.save(product);
	}

	@Override
	public List<Products>  getProductByProductname(String productname) {
		return productdao.findByProductname(productname);
		
	}

	@Override
	public List<Products> getProductsByBrand(String brand) {
		return productdao.findByBrand(brand);
	}

	@Override
	public List<Products> getProductsByCategoryid(int categoryid) {
		return productdao.findByCategoryid(categoryid);
	}

	

	@Override
	public boolean deleteById(int productid) {
		if(productdao.existsById(productid)) {
			productdao.deleteById(productid);
			return true;
		}
		return false;
	}

	@Override
	public Products updateProduct(Products product) {
		return productdao.save(product);
	}

	@Override
	public Products getProductById(int productid) {
		Optional<Products> product=productdao.findById(productid);
		return product.orElse(null);
	}
	
	@Override
	public Products saveProduct(Products product, MultipartFile image) {
		String fileName = storageService.store(image);
		product.setImage(fileName);
		return productdao.save(product);
	}


}
