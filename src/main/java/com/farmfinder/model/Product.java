package com.farmfinder.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.farmfinder.model.Category ;

/**
 * @author Group: FarmFinder
 * 
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
	private String FarmID ;
	private String name ;
	private double price ;
	private String category_id ;
	
	/*******************Setters and Getters***********************/
	@JsonIgnore
	public String getFarmID() {
		return FarmID;
	}
	public void setFarmID(String farmID) {
		FarmID = farmID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category_id;
	}
	public void setCategory(String category) {
		this.category_id = category;
	}
	
	
}
