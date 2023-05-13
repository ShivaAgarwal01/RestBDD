package restassuredTest;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo3_PUT_Request {

	public static HashMap map = new HashMap();

	String empName  = RestUtils.getFirstName();
	int emp_id=2;

	@BeforeClass
	public void putData() {

map.put("name",empName);

RestAssured.baseURI = "https://reqres.in/api";
RestAssured.basePath = "/update/"+emp_id;


	}
	@Test
	
	public void testPost() {
		
		given()
		.contentType("application/json; charset=utf-8")
		.body(map)
		
		.when()
		.put()
		
		.then()
		.statusCode(200)
		.log().all();
		
	}


}
