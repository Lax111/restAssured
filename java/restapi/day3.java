package restapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class day3 {

	String token = "Bearer 30fc0067beee4d63f35b12731b3cae7781966fa195a056ad5ed628224f5c96bd";
//	@Test
//	public void getUsers() {
//	
//	RestAssured.baseURI= "https://gorest.co.in/public/v2/users";
//	
//	Response response = RestAssured
//	.given()
//	.header("Accept","application/json")
//	.header("Content-Type","application/json")
//	.header("Authorization",token)
//	.when()
//	.get();
//	
//	response.then().statusCode(200);	
//}
	@Test
	public void createUser() {
		
		String requestBody = "{\"name\":\"Laxmi Ramakrishna\", \"gender\":\"male\", \"email\":\"laxmi.ramakrishna@15ce.com\", \"status\":\"active\"}";
		RestAssured.baseURI= "https://gorest.co.in/public/v2/users";
		Response response = RestAssured
		.given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.body(requestBody)
		.when()
		.post();
		response.then().log().all();
		response.then().statusCode(201);
	}	
		
	@Test
	public void updateUser() {
		String email = getSaltString()+"@gmail.com";
		String requestBody = "{\"name\":\"Allasani Peddana\", \"email\":\""+ email +"\", \"status\":\"active\"}";

		RestAssured.baseURI= "https://gorest.co.in/public/v2/users";
		Response response = RestAssured
		.given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.body(requestBody)
		.when()
		.patch("/1700656");
		response.then().log().all();
		response.then().statusCode(200);	
	}
		
		@Test
		public void deleteUser() {
		
			RestAssured.baseURI= "https://gorest.co.in/public/v2/users";
			Response response = RestAssured
			.given()
			.header("Accept","application/json")
			.header("Content-Type","application/json")
			.header("Authorization",token)
			.when()
			.delete("/1700656");
			response.then().log().all();
			response.then().statusCode(204);	
			
		}
	}