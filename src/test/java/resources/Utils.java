package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification reqSpec;
	public RequestSpecification requestspecification() throws IOException {
		
		if(reqSpec == null) {
		PrintStream log = new PrintStream(new FileOutputStream("/Users/geerthanakannan/eclipse-workspace/ApiCucumberFramework/src/test/resources/resources/Log4jProperties/logging.txt"));
		//RestAssured.baseURI = "https://rahulshettyacademy.com";
		reqSpec= new RequestSpecBuilder().setBaseUri(getglobalvalues("baseurl"))
				.addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		
		return reqSpec;
		}
		
		return reqSpec;
	}

	public String getglobalvalues(String key) throws IOException {
		//It is used to extract baseurl from global.properties file
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("/Users/geerthanakannan/eclipse-workspace/ApiCucumberFramework/src/test/resources/resources/ConfigProperties/global.properties");
		prop.load(fis);
		prop.getProperty(key);
		
		return prop.getProperty(key);
	}
	
	public String getJsonpath(Response response,String key) {
		
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
	}
	
	
}
