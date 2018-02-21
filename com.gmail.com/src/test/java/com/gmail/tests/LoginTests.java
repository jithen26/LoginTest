package com.gmail.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gmail.pages.InboxPage;
import com.gmail.pages.LoginPage;

public class LoginTests {
	WebDriver driver;
    LoginPage objLoginPage;
    InboxPage objInboxPage;
   
    @BeforeTest
    public void setup(){
    	System.setProperty("webdriver.gecko.driver", "C:\\Gecko\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://gmail.com");
    }

   
    @Test(priority=0)
    public void testInboxPageTitle() throws InterruptedException{
        //Create Login Page object
    objLoginPage = new LoginPage(driver);
    //Verify login page title
    String loginPageTitle = objLoginPage.getLoginTitle();
    Assert.assertTrue(loginPageTitle.toLowerCase().contains("gmail"));

    //login to application
    objLoginPage.loginToGmail("jithendralj2testuser1", "testpassw0rd@123");
    // go the next page
    objInboxPage = new InboxPage(driver);
    //Verify Inbox page text
    Assert.assertTrue(objInboxPage.getInboxPageTitle().toLowerCase().contains("inbox"));
    }
    
    @AfterTest
    public void teardown(){
    	driver.quit();
    }
}

