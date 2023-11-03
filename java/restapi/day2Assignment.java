package restapi;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class day2Assignment {

	@Test
	public void ApiChaining() {
		RestAssured.baseURI = "https://reqres.in/api";
		
		Response response = given()
		.param("page",2)		
		.when().get("/users").then().extract().response();















	}
}
