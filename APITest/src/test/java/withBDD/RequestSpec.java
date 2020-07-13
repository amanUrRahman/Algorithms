package withBDD;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

	public class WithRequestSpecification {

		RequestSpecification requestSpecification;

		@BeforeClass
		public void setupRequestSpecification() {
			requestSpecification = given().baseUri("https://restful-booker.herokuapp.com").basePath("/booking");
		}

		@Test
		public void getAllBookings() {
			given(requestSpecification).when().then().statusLine("HTTP/1.1 200 OK");
		}

		@Test
		public void getBookingDetailsWithInvalidFirstName() {
			given(requestSpecification).param("firstName", "Rahul").when().then().statusLine("HTTP/1.1 200 OK");
		}

	}

}
