package withoutBDD;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.specification.RequestSpecification;

public class RequestSpec {

	public class WithRequestSpecification {

		RequestSpecification requestSpecification;
		Response response;

		@BeforeClass
		public void setupRequestSpecification() {
			requestSpecification = RestAssured.given();
			requestSpecification.baseUri("https://restful-booker.herokuapp.com");
			requestSpecification.basePath("/booking");
		}

		@Test
		public void getAllBookings() {
			response = requestSpecification.get();
			ValidatableResponse valResp = response.then();
			valResp.statusLine("HTTP/1.1 200 OK");
		}

		@Test
		public void getBookingDetailsWithInvalidFirstName() {
			requestSpecification.param("firstName", "Rahul");
			response = requestSpecification.get();
			ValidatableResponse valResp = response.then();
			valResp.statusLine("HTTP/1.1 200 OK");
		}
	}
}
