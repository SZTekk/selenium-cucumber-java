package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources/cucumber.gui"}
        , monochrome = true
		, plugin = {"pretty" ,"html:target/cucumber-reports/cucumber" ,
		  "json:target/cucumber-reports/cucumber.json" ,
		  "junit:target/cucumber-reports/cucumber.xml",
		  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		  }
        , glue = { "com.demo.tests" }
        , dryRun= false
        //, tags = "@login"
)

public class JunitRunner extends AbstractTestNGCucumberTests
{
	
}