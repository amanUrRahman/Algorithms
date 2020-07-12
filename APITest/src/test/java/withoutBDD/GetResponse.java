package withoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetResponse {
	
	
	@Test
	public void validateGet() {
		
		RequestSpecification request = RestAssured.given();
		request.baseUri("https://restful-booker.herokuapp.com/booking");
		Response response = request.get();
		System.out.println(response.asString());
		ValidatableResponse valRes = response.then();
		valRes.statusCode(200);
		valRes.statusLine("HTTP/1.1 200 OK");
	}

}
