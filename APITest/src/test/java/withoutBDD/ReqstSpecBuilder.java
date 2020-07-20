package withoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReqstSpecBuilder {

	@Test
	public void requestSpecBuild() {
	
		RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
		reqBuilder.setBaseUri("https://restful-booker.herokuapp.com");
		reqBuilder.setBasePath("/booking");
		RequestSpecification reqSpec = reqBuilder.build();
		
		Response res1 = reqSpec.get();
		System.out.println(res1.asString());

		Response res2 = RestAssured.given(reqSpec).get();
		System.out.println(res2.asString());

		Response res3 = RestAssured.given().spec(reqSpec).get();
		System.out.println(res3.asString());
	}

}
