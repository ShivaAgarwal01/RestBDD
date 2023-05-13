package restassuredTest;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo4_DELETE_Request {

	 @Test
	 public void deleteEmployeeRecord() {
		 
		 
		 RestAssured.baseURI= "https://reqres.in/api";
		 RestAssured.basePath="users/2";
		 
		 Response response = // to store below code in response variable
		 
		 given()
		 .when()
		    .delete()
		 .then()
		     .statusCode(204)
		     .statusLine("HTTP/1.1 204 No Content")
		     .log().all()
		     .extract().response(); //It will extract all data in response variable
		 
		 String jsonAString = response.asString();
		
	 }
}
