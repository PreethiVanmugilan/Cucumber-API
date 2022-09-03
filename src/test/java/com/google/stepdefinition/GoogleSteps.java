package com.google.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.google.objectrepository.AddLocation;
import com.google.objectrepository.Location;
import com.google.resources.APIResources;
import com.google.resources.CommonUtils;

public class GoogleSteps extends CommonUtils{
	
	AddLocation loc;
	CommonUtils c = new CommonUtils();
	
	@Given("I want to add payload")
	public void i_want_to_add_payload() {
		
		loc = new AddLocation();
		loc.setAccuracy(50);
		loc.setName("Preethi");
		loc.setAddress("Pulicat");
		loc.setPhone_number("8786543339");
		
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		loc.setLocation(l);
		
		List<String> t = new ArrayList<String>();
		t.add("Chemical");
		t.add("Engineering");
		loc.setTypes(t);
		
		loc.setWebsite("http://www.cgtech.com/");
		loc.setLanguage("Tamil");
	   
	}
	Response response;
	RequestSpecification request;

	@When("User submit {string} api")
	public void user_submit_api(String string) throws FileNotFoundException {
		
		c.requestSpecDif();
		
		request = given().spec(requestDiffApproach).body(loc);
	  
	}

	@Then("User validate the status code is {int}")
	public void user_validate_the_status_code_is(Integer int1) {
		
		ResponseSpecification response2 = c.response(); 
				
		APIResources resource = APIResources.valueOf("addPlaceApi");
		String resource2 = resource.getResource();
		System.out.println(resource.getResource());
		
		response = request.when().post(resource2)
		.then().spec(response2).extract().response();
		
		int int2 = response.getStatusCode();
		String s = String.valueOf(int2);
		Assert.assertEquals(int1.toString(), s);
	   
	}
}