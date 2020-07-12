package withBDD;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class GetResponse {

	@Test
	public void validateGet() {

		given().
			baseUri("https://restful-booker.herokuapp.com/booking").
		when().
			get().
		then().
			statusCode(200).and().
			statusLine("HTTP/1.1 200 OK").and().
			body("bookingid", hasSize(10)).and().
			body("bookingid[3]", is(4));
			

	}
}
