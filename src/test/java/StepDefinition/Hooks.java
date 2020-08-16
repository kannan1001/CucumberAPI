package StepDefinition;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@deleteplace")
	public void beforeScenario() throws IOException {
		googleplacerequestStepDefinition stepdef = new googleplacerequestStepDefinition();
		
		//execute this code only when place id is null
		//write a code that will give uou place id
		if(googleplacerequestStepDefinition.place_id == null) {
			stepdef.add_place_payload_with("meena", "Hindi", "19,ganga nagar Holland");
			stepdef.user_calls_with_post_http_request("AddplaceAPI", "POST");
			stepdef.verify_place_id_created_maps_to_using("meena", "getplaceAPI");
			
		}
		
		
	}

}
