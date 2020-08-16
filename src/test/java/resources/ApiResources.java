package resources;

public enum ApiResources {
	//enum is a special class which has a collection of constant
	
	AddplaceAPI("/maps/api/place/add/json"),
	getplaceAPI("/maps/api/place/get/json"),
	deleteplaceAPI("/maps/api/place/delete/json");
	private String resource;

	
	ApiResources(String resource) {
		this.resource = resource;
		
	}
	
	public String getResource() {
		
		return resource;
	}
	

}
