package com.project.secondhand.vo;

public class Category {

	private String categoryName;
	private String categoryType;
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryType() {
		return categoryType;
	}
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
	@Override
	public String toString() {
		return "Category [categoryName=" + categoryName + ", categoryType=" + categoryType + "]";
	}
}
