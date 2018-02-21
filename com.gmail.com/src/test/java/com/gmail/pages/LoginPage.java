package com.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	    /**
	     * All WebElements are identified by @FindBy annotation
	     */
	    WebDriver driver;
	    @FindBy(id="identifierId")
	    WebElement username;	    

	    @FindBy(id="identifierNext")
	    WebElement nextButton;
	    
	    @FindBy(name="password")
	    WebElement password;
	    
	    @FindBy(id="passwordNext")
	    WebElement passwordNext;
	    public LoginPage(WebDriver driver){
	        this.driver = driver;
	        //This initElements method will create all WebElements
	        PageFactory.initElements(driver, this);
	    }

	    //Set user name in textbox
	    public void setUserName(String strUserName){
	    	username.sendKeys(strUserName);	        
	    }

	    //Set password in password textbox

	    public void setPassword(String strPassword){
	    password.sendKeys(strPassword);
	    }

	    //Click on login button
	    public void clickLogin(){
	    	nextButton.click();
	    }
	    
	    public void clickNext()
	    {
	    	passwordNext.click();
	    }

	    public String getLoginTitle(){
	     return   driver.getTitle();
	    }


	    /**

	     * This POM method will be exposed in test case to login in the application

	     * @param strUserName

	     * @param strPasword

	     * @return
	     * @throws InterruptedException 

	     */

	    public void loginToGmail(String strUserName,String strPasword) throws InterruptedException{

	        //Fill user name

	        this.setUserName(strUserName);

	        //Fill password
	        this.clickLogin();
	        Thread.sleep(3000);
	        this.setPassword(strPasword);

	        //Click Login button
	        Thread.sleep(3000);
	        this.clickNext();

	                

	    }

	}

