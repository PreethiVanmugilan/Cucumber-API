package com.google.resources;

public enum APIResources {
	
	addPlaceApi("/maps/api/place/add/json"),
	getPlaceApi("/maps/api/place/get/json"),
	deletePlaceApi("/maps/api/place/delete/json");
	
	private String resources;
	APIResources(String resources){
		this.resources = resources;
	}
	
	public String getResource(){
		return resources;
	}
	

}
