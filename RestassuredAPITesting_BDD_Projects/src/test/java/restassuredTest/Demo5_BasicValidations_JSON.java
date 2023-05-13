package restassuredTest;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo5_BasicValidations_JSON {
	
	@Test(priority = 1)
	public void testStatusCode()
	{
		given()
		.when()
		 .get("https://reqres.in/api/users/7")
		.then()
		  .statusCode(200);
	//	  .log().all();
		
	}
	
	@Test(priority = 2)
	
	public void testLogging() {
		
		given()
		
		.when()
		  .get("https://reqres.in/api/unknown/2")
		.then()
		.statusCode(200)
		.log().all();
	}
	

	@Test(priority = 3)
	
	public void testSingleContent() {
		
		given()
		
		.when()
		  .get("https://reqres.in/api/unknown/2")
		.then()
		.statusCode(200)
		.body("data.year",equalTo(2001));
	}

//		@Test(priority = 4) //This TC gets failed due to some validations
//		
//		public void testMultipleContent() {
//			
//			given()
//			
//			.when()
//			  .get("https://reqres.in/api/users?page=2")
//			.then()
//		
//			.body("data.name",hasItems("cerulean","true red","tigerlily"));
//		}
	
@Test(priority = 5)
	
	public void testParamsAndHeaders() {
		
		given()
		.param("Myname", "shiva")
		.header("MyHeader", "Indian")
		
		.when()
		  .get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.log().all();
	
		
	}
}
