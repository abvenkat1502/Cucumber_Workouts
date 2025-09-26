package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/featureFiles", 
   glue = {"stepDefinitions","hooks"}, tags = "@One", plugin = {
		   "pretty",
		    "html:Cucumber_Reports/cucumber-reports.html",
		    "json:Cucumber_Reports/cucumber.json",
		    "junit:Cucumber_Reports/cucumber.xml", 
		    
		  }
		)
public class RunnerClass {
	
}

