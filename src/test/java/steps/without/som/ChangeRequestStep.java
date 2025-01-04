package steps.without.som;

import org.hamcrest.Matchers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ChangeRequestStep {
	
	RequestSpecification requestSpec;
	String request_payload = """
			{
               "description": "Call Post MEthod with request payload",
               "short_description": "RESTAPIDEC2024",
               "state": "1",
               "urgency": "1"
            }
			""";
	Response response;
	
	@Given("Set the Endpoint")
	public void set_the_endpoint() {
		requestSpec = RestAssured.given()
		                         .baseUri("https://dev262949.service-now.com")
		                         .basePath("/api/now/table");
	}

	@Given("Set the Auth")
	public void set_the_auth() {
		requestSpec.auth()
		           .basic("admin", "vW0eDfd+A0V-")		           
		           .log().all();
	}

	@When("hit the post method to create a change request")
	public void hit_the_post_method_to_create_a_change_request() {
		response = requestSpec.contentType(ContentType.JSON)
				.when()
				.body(request_payload)
				.post("/change_request");
	}
	
	@When("hit the get method to fetch a single record base on the {string} sysId")
	public void hit_the_get_method_to_fetch_a_single_record_base_on_the_sys_id(String sysId) {
		response = requestSpec
				.when()
		        .get("/change_request/"+sysId);
	}
	

	@Then("validate the response code and the response body")
	public void validate_the_response_code_and_the_response_body() {
		response.then()
                .statusCode(201)
                .statusLine(Matchers.containsString("Created"))
                .contentType(ContentType.JSON);
	}
	
	@Then("validate the get method response code")
	public void validate_the_get_method_response_code() {
		response.then()
        .statusCode(200)
        .statusLine(Matchers.containsString("OK"))
        .contentType(ContentType.JSON);
	}

}