package step_definitions;

import org.junit.runner.RunWith;
import org.w3c.dom.views.AbstractView;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"classpath:features/"},
		glue = { "step_definitions.Addition", "step_definitions.Hooks", "step_definitions.BrowserCommands"},
		plugin = {"pretty", "html:target/cucumber-html-report.html","json:target/cucumber.json"}
		// tags = {}
		)
public class RunCukesTest{
	
}