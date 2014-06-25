package com.farmfinder.metadata;

import java.util.ArrayList;

/*
 * This class will be used to add metadata info about 
 * a particular class to a collection.   
 */

public class Metadata {	
	private String title ; /*Class title*/
	private ArrayList<String[]> attributes ; 	/*Class vars will be stored here with description*/
	
	/*Getters and setters*/
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ArrayList<String[]> getAttributes() {
		return attributes;
	}
	public void setAttributes(ArrayList<String[]> attributes) {
		this.attributes = attributes;
	} 
	
	/*Method to add an attribute for a class*/
	public void addAttribute( String[] attribute ){
		this.attributes.add(attribute) ;
	}
}
