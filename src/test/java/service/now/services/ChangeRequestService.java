package service.now.services;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ChangeRequestService {	
	
	private Response response;
	
	private RequestSpecification given(RequestSpecification requestSpecification) {
		return RestAssured.given()
				          .spec(requestSpecification);
	}
	
	public void createNewRecord(RequestSpecification requestSpecification, String requestBody) {
		response = given(requestSpecification)
		.contentType(ContentType.JSON)
		.when()
		.body(requestBody)
		.post("/change_request");
	}
	
	public void validateCreateResponse() {
		response.then()
		        .statusCode(201)
		        .statusLine(Matchers.containsString("Created"))
		        .contentType(ContentType.JSON);
	}
	
	public void fetchRecord(RequestSpecification requestSpecification, String sysId) {
		response = given(requestSpecification)
				   .when()
				   .get("/change_request"+sysId);
	}
	
	public void validateSuccessResponse() {
		response.then()
        .statusCode(200)
        .statusLine(Matchers.containsString("OK"))
        .contentType(ContentType.JSON);
	}

}