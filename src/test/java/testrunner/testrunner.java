package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/resources/Features",glue = {"StepDefinition"},plugin ="json:target/jsonReports/cucumber-report.json"
)
public class testrunner {
	
}//,tags = {"@Regression"}
