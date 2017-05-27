package com.ecvictor.selenium.junit;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ConcordiaTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    private int timeout = 5000;
    private int interval = 500;

    @Before
    public void setUp() throws Exception {
        //chose driver type
        String os = (System.getProperty("os.name"));

        if (os.equalsIgnoreCase("Mac OS X"))
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        else System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--kiosk");

        driver = new ChromeDriver(chromeOptions);

        baseUrl = "https://www.concordia.ca";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testAbout() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a[@href=\"/about.html\" and @class]")).click();

        while (timeout > 0) {
            String name = driver.getTitle();
            if (name.equals("About")) {
                System.out.println("Found the Graduate admissions: " + timeout);
                break;
            } else {
                System.out.println("Not found the Graduate admissions,wait 500 ms");
                Thread.sleep(interval);
                timeout -= interval;
            }
        }
        if (timeout <= 0)
            Assert.fail("Test failed");

    }

    @Test
    public void testGraduateTest() throws Exception {
        driver.get(baseUrl + "/");
        int counter = 3;
        Boolean success = false;
        while (counter-- > 0) {
            System.out.println("Test Start: ");
            Actions actions = new Actions(driver);
            WebElement menu = driver.findElement(By.xpath("//a[@href=\"/admissions.html\" and @class]"));
            actions.moveToElement(menu).perform();

            WebElement subMenu = driver.findElement(By.linkText("Graduate"));
            actions.moveToElement(subMenu);
            actions.click().build().perform();

            //wait for page shown up
            while (timeout > 0) {
                String name = driver.getTitle();
                if (name.equals("Graduate")) {
                    System.out.println("Found the Graduate admissions: " + timeout);
                    success = true;
                    break;
                } else {
                    System.out.println("Not found the Graduate admissions,wait 500 ms");
                    Thread.sleep(interval);
                    timeout -= interval;
                }
            }
            if (success) break;
        }

        if (!success)
            Assert.fail("Test failed");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
