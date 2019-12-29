package com.ecommerce.B2C.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@Table(name = "products" )
@EntityListeners(AuditingEntityListener.class)
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productid;
	@NotBlank
	private String productname;
	@NotBlank
	private String brand;
	@NotNull
	private Long price;
	@NotBlank
	private String color;
	@NotBlank
	private String size;
	@NotBlank
	private String sku;
	@NotBlank
	private String seller;
	public Long getProductid() {
		return productid;
	}
	public void setProductid(long productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productname=" + productname + ", brand=" + brand + ", price="
				+ price + ", color=" + color + ", size=" + size + ", sku=" + sku + ", seller=" + seller + "]";
	}
	
	
}