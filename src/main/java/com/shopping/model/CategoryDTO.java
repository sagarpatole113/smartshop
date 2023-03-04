package com.shopping.model;



import org.springframework.beans.BeanUtils;

import com.shopping.entities.Category;

public class CategoryDTO {
	private int categoryid;
	private String categoryname;
	public CategoryDTO(){
		
	}
	public CategoryDTO(int categoryid, String categoryname) {
		this.categoryid = categoryid;
		this.categoryname = categoryname;
	}
	
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", categoryname=" + categoryname + "]";
	}
	public static CategoryDTO fromEntity(Category category) {
		CategoryDTO dto = new CategoryDTO();
		BeanUtils.copyProperties(category, dto);
		return dto;
	}
	
	public static Category toEntity(CategoryDTO dto){
		Category category = new Category();
		BeanUtils.copyProperties(dto, category);
		return category;
	}

}
