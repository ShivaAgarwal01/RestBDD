package restassuredTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Header;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo1_GET_Request {

	@Test
	public void getUserDetails() {
		
		given()
		 .when()
		   .get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.assertThat().body("page", equalTo(2))
		.header("Content-Type","application/json; charset=utf-8");
	}
	
}


