package withBDD;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class PostResponse {

	@Test
	public void validatePost() {
		String jsonString = "{\"username\" : \"admin\",\"password\" : \"password123\"}";
		given().
			baseUri("https://restful-booker.herokuapp.com/auth").
			contentType(ContentType.JSON).
			body(jsonString).
		when().
			post().
		then().
			statusCode(200).
			body("token", notNullValue()).
			body("token.length()", is(15)).
			body("token", matchesRegex("^[a-z0-9]+$"));
	}

}
