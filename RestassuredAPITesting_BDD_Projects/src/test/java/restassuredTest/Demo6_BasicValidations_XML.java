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

public class Demo6_BasicValidations_XML {
	
	//Verifying Single content in XML Response
	@Test(priority = 1)
	public void testSingleContent() {
		
		given()
		
		.when()
		 .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		
		.then()
		  .body("CUSTOMER.ID",equalTo("15"))
		  .log().all();
		
		
	}
	
	//Verifying Multiple contents in XML Response
	
	@Test(priority = 2)
	public void testMultipleContents() {
		
		given()
		
		.when()
		 .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		
		.then()
		  .body("CUSTOMER.ID",equalTo("15"))
		  .body("CUSTOMER.FIRSTNAME",equalTo("Bill"))
		  .body("CUSTOMER.LASTNAME",equalTo("Clancy"))
		  .body("CUSTOMER.STREET",equalTo("319 Upland Pl."))
		  .body("CUSTOMER.CITY",equalTo("Seattle"));
	}
	
	//Verifying all the content in XML Response in one go
	
	@Test(priority = 3)
	public void testMultipleContentsInOneGo() {
		
		given()
		
		.when()
		 .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		
		.then()
		  .body("CUSTOMER.text()",equalTo("15BillClancy319 Upland Pl.Seattle"));
		  
	}
	
	//Find values using XML Path in XML response
	
	@Test(priority = 4)
	public void testUsingXpath1() {
		
		given()
		
		.when()
		 .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		
		.then()
		  .body(hasXPath("/CUSTOMER/FIRSTNAME",containsString("Bill")));
		  
	}

	//XPath with text() function
	
	@Test(priority = 5)
	public void testUsingXpath2() {
		
		given()
		
		.when()
		 .get("http://thomas-bayer.com/sqlrest/INVOICE/")
		
		.then()
		  .body(hasXPath("/INVOICEList/INVOICE[text()='30']"))
		  .log().all();
		  
	}

}
