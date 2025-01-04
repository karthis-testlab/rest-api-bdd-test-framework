package api.base;

import api.design.ApiClient;
import api.design.ResponseAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredBase implements ApiClient {	
	
	private RequestSpecification given(RequestSpecification requestSpecification) {
		return RestAssured.given()
				          .spec(requestSpecification);
	}

	@Override
	public ResponseAPI get(RequestSpecification request, String endPoint) {
		Response response = given(request).get(endPoint);
		return new RestAssuredResponseBase(response);
	}

	@Override
	public ResponseAPI post(RequestSpecification request, String endPoint) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseAPI post(RequestSpecification request, String endPoint, Object body) {
		// TODO Auto-generated method stub
		return null;
	}	

	@Override
	public ResponseAPI put(RequestSpecification request, String endPoint, Object body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseAPI delete(RequestSpecification request, String endPoint) {
		// TODO Auto-generated method stub
		return null;
	}

}