package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Addplace;
import pojo.location;

public class Testdatabuild {
	
	public Addplace addplacepayload(String name, String language, String address) {
		Addplace addp = new Addplace();
		
		location l = new location();
		l.setLat(-39.495494);
		l.setLng(34.427362);
		addp.setLocation(l);
		addp.setAccuracy(90);
		addp.setName(name);
		
		List<String> t = new ArrayList<String>();
		t.add("shoe park");
		t.add("shop");
		
		
		addp.setPhone_number("(+91) 976 893 4321");
		addp.setAddress(address);
		addp.setTypes(t);
		addp.setWebsite("https://rahulshettyacademy.com/");
		addp.setLanguage(language);
		
		return addp;
	}

	

	public String deleteplacepayload(String place_id) {
		return "{\n" + 
				"    \"place_id\":\""+ place_id +"\"   	 	\n" + 
				"}";
	}
}
