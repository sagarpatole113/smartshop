package com.shopping.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.entities.Products;
import com.shopping.model.ProductDTO;
import com.shopping.model.ProductInDTO;
import com.shopping.model.Response;
import com.shopping.services.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductControllerImpl {
	@Autowired
	private ProductService productService;

	@PostMapping("/")
	public ResponseEntity<?> addProduct(ProductDTO productsDTO) {
		Products product = ProductDTO.toEntity(productsDTO);
		product = productService.addProduct(product);
		return Response.success(product);
}
	@GetMapping("/")
	public ResponseEntity<?> getAllProducts() {
		List<Products> list = productService.getAllProducts();
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		for (Products product : list)
			result.add( ProductDTO.fromEntity(product) );
		return Response.success(result);
	}
	
	@GetMapping("/prodbycategory/{categoryid}")
	public ResponseEntity<?> getProductsByCategoryId(@PathVariable("categoryid") int categoryid) {
		List<Products> list = productService.getProductsByCategoryid(categoryid);
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		for (Products product : list)
			result.add( ProductDTO.fromEntity(product) );
		return Response.success(result);
	}
	
	@GetMapping("/prodbyproductid/{productid}")
	public ResponseEntity<?> getProductsByProductId(@PathVariable("productid") int productid) {
		Products product = productService.getProductById(productid);
		ProductDTO productDTO = ProductDTO.fromEntity(product);
		System.out.println(productDTO);
		if(productDTO!=null) {	
		return Response.success(productDTO);
		}
		return Response.error("not found");	
	}
	
	
	
	@GetMapping("/prodbybrand/{brand}")
	public ResponseEntity<?> getProductsByBrand(@PathVariable("brand") String brand) {
		List<Products> list = productService.getProductsByBrand(brand);
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		for (Products product : list)
			result.add( ProductDTO.fromEntity(product) );
		return Response.success(result);
	}
	
	@GetMapping("/prodbyname/{productname}")
	public ResponseEntity<?> getProductsByName(@PathVariable("productname") String productname) {
		List<Products> list = productService.getProductByProductname(productname);
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		for (Products product : list)
			result.add( ProductDTO.fromEntity(product) );
		return Response.success(result);
	}
	
	
	
	@RequestMapping("/updateProduct/{productid}")
	public ResponseEntity<?> updateProduct(ProductDTO productsDTO, @PathVariable("productid") int productid){
		Products product=productService.getProductById(productid);
		System.out.println(product);
		product.setPrice(productsDTO.getPrice());
		product.setQuantity(productsDTO.getQuantity());
		product.setProductdesc(productsDTO.getProductdesc());
		Products updatedprod =productService.updateProduct(product);
		ProductDTO productDTO = ProductDTO.fromEntity(updatedprod);
		System.out.println(productDTO);
		if(productDTO!=null) {	
		return Response.success(productDTO);
		}
		return Response.error("not found");	
	}
	
	@RequestMapping("/delete/{productid}")
	public ResponseEntity<?> deleteById(@PathVariable("productid") int productid) {
		 boolean status = productService.deleteById(productid);
		 System.out.println(status);
			if(status) {	
			
			return Response.success("product deleted successfully");
			}
			return Response.error(" product not found");	
	}
	
	@PostMapping("")
	public ResponseEntity<?> save(ProductInDTO productDto) {
		Products product = ProductInDTO.toEntity(productDto);
		product = productService.saveProduct(product, productDto.getImage());
		return Response.success(product);
	}
	
}


