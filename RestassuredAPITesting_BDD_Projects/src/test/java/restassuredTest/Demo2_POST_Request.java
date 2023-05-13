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

public class Demo2_POST_Request {
	
	public static HashMap map = new HashMap();
@BeforeClass
	public void postData() {
	map.put("email", RestUtils.getEmail());
	
	RestAssured.baseURI = "https://reqres.in/api";
	RestAssured.basePath = "/login";
		
	}

@Test
public void testPost() {
	
	given()
	.contentType("application/json")
	.body(map)
	
	.when()
	.post()
	
	.then()
	.statusCode(400)
	.and()
	.body("error", equalTo("Missing password"))
	.and()
	.header("Content-Type","application/json; charset=utf-8");
}
}


