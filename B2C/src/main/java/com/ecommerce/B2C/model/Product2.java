package com.ecommerce.B2C.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.ecommerce.B2C.model.Product;


/**
 * The persistent class for the student database table.
 * 
 */

public class Product2 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productname;
	private Integer count;
	
	public Product2(String productname) {
		super();
		this.productname = productname;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
		
}