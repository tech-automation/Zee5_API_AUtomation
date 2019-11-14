package test;

import co.Zee5.api.helper.RestBaseClass;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder extends RestBaseClass {

	public static RequestSpecification requestSpecBuilder() {

		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setContentType("application/json");
		builder.addHeader("X-SHARECHAT-AUTHORIZED-USERID", "232908521");
		RequestSpecification requestSpec = builder.build();
		return requestSpec;
	}

	public static ResponseSpecification responseSpecBuilder() {
		ResponseSpecBuilder rBuilder = new ResponseSpecBuilder();
		rBuilder.expectStatusCode(200);
		rBuilder.expectContentType("application/json");
		ResponseSpecification responseSpec = rBuilder.build();
		return responseSpec;
	}

}
