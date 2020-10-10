package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features =  "src/main/java/Features/login.feature" , 
        glue = "stepDefinitions",
        plugin = "json:./reports.json"
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
