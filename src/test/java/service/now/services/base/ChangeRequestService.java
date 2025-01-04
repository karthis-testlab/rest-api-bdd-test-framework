package service.now.services.base;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import api.base.RestAssuredBase;
import api.design.ResponseAPI;
import io.restassured.specification.RequestSpecification;

public class ChangeRequestService {
	
	RestAssuredBase restAssuredBase = new RestAssuredBase();	
	private ResponseAPI responseAPI;	
	
	
	public void createNewRecord(RequestSpecification requestSpecification, String requestBody) {
		
	}
	
	public void validateCreateResponse() {
		
	}
	
	public void fetchRecord(RequestSpecification requestSpecification, String sysId) {
		responseAPI = restAssuredBase.get(requestSpecification, "/change_request/"+sysId);
	}
	
	public void validateSuccessResponse() {
		MatcherAssert.assertThat(responseAPI.getStatusCode(), Matchers.equalTo(200));
		MatcherAssert.assertThat(responseAPI.getStatusMessage(), Matchers.equalToIgnoringCase("OK"));
		MatcherAssert.assertThat(responseAPI.getContentType(), Matchers.equalTo("application/json"));
	}

}