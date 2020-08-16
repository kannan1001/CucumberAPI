package StepDefinition;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;
import pojo.Addplace;
import pojo.location;
import resources.ApiResources;
import resources.Testdatabuild;
import resources.Utils;

public class googleplacerequestStepDefinition extends Utils {
	RequestSpecification Request1;
	ResponseSpecification res;
	Response Response1;
	Testdatabuild data = new Testdatabuild();
	static String place_id;

	@Given("add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {

		Request1 = given().spec(requestspecification()).body(data.addplacepayload(name, language, address));
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_post_http_request(String resource, String method) {

		// constructor of ApiResources will be called with value of resource you provide
		ApiResources ApiResource = ApiResources.valueOf(resource);
		System.out.println(ApiResource.getResource());

		res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		if (method.equalsIgnoreCase("POST")) {
			Response1 = Request1.when().post(ApiResource.getResource());

		} else if (method.equalsIgnoreCase("GET")) {
			Response1 = Request1.when().get(ApiResource.getResource());
		}

		// .then().spec(res).extract().response();

	}

	@Then("Api call is success with status code {int}")
	public void api_call_is_success_with_status_code(Integer int1) {
		assertEquals(Response1.getStatusCode(), 200);

	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyvalue, String Expectedvalue) {
		
		
		assertEquals(getJsonpath(Response1,keyvalue ), Expectedvalue);
	}
	
	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
	   //request spec
		place_id = getJsonpath(Response1,"place_id");
		Request1 = given().spec(requestspecification()).queryParam("place_id", place_id);
		user_calls_with_post_http_request(resource, "GET");
		String actualname = getJsonpath(Response1,"name");
		assertEquals(actualname, expectedName);
	}
	
	@Given("DeletePlace payload")
	public void delete_place_payload() throws IOException {
		
		
		Request1 = given().spec(requestspecification()).body(data.deleteplacepayload(place_id));

	}

}
