package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		          features = {"src/test/java/features/ChangeRequest.feature"},
		          glue = {"steps.som"},
		          dryRun = false,
		          publish = true,
		          plugin = {		        	
		              
		        		  "pretty",
		        		  "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
		        		  "html:report/result.html"		        		  
		        		  
		          }
		        )
public class TestNGRunner extends AbstractTestNGCucumberTests {

}