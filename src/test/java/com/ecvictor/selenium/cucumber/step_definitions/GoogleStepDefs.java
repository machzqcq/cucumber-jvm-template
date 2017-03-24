package com.ecvictor.selenium.cucumber.step_definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.assertEquals;


public class GoogleStepDefs {
    public WebDriver driver;

    public GoogleStepDefs()
    {
    	driver = Hooks.driver;
    }
    
    @When("^I open google website$")
    public void i_open_seleniumframework_website() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://www.google.com");
    }

    @Then("^I validate google title and URL$")
    public void i_print_title_and_URL() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
      assertEquals("Selenium Framework | Selenium, Cucumber, Ruby, Java et al.",driver.getTitle());
      assertEquals("http://www.seleniumframework.com/",driver.getCurrentUrl());
    }
    
}