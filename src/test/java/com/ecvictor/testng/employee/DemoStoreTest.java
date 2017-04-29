package com.ecvictor.testng.employee;

/**
 * Created by ccao on 2017-04-29.
 */
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.testng.annotations.Parameters;

public class DemoStoreTest {

    private static WebDriver driver;

    @DataProvider(name = "Authentication")

    public static Object[][] credentials() {

        return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" }};

    }

    // Here we are calling the Data Provider object with its Name

    @Test(dataProvider = "Authentication")

    public void demoStoreTest(String sUsername, String sPassword) {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://www.store.demoqa.com");

        driver.findElement(By.xpath(".//*[@id='account']/a")).click();

        driver.findElement(By.id("log")).sendKeys(sUsername);

        driver.findElement(By.id("pwd")).sendKeys(sPassword);

        driver.findElement(By.id("login")).click();

        driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();

        driver.quit();

    }

}