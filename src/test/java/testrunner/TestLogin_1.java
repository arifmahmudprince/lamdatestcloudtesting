package testrunner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class TestLogin_1 {

    public String username = "arif0964";
    public String accesskey = "*******************";
    public static RemoteWebDriver driver = null;
    public String gridURL = "@hub.lambdatest.com/wd/hub";
    boolean status = false;
    LoginPage loginPage;

    @BeforeClass
    public void setUp() throws Exception {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("114.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", username);
        ltOptions.put("accessKey", accesskey);
        ltOptions.put("geoLocation", "BD");
        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("timezone", "Dhaka");
        ltOptions.put("build", "LamdaSelenium");
        ltOptions.put("project", "LamdaTestSampleWebLogin");
        ltOptions.put("name", "WebLogin");
        ltOptions.put("console", "error");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        browserOptions.setCapability("LT:Options", ltOptions);
        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), browserOptions);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void doLogin() throws InterruptedException {
        loginPage = new LoginPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com");
        loginPage.doLogin("Admin", "admin123");
        Thread.sleep(5000);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "dashboard";
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

    @AfterClass
    public void tearDown() throws Exception {
        if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.quit();
        }
    }
}
