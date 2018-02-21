package com.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxPage {
	    WebDriver driver;
	    @FindBy(xpath="//span[@class='nU ']")
	    WebElement inboxPageTitle;

	    public InboxPage(WebDriver driver){
	        this.driver = driver;
	        //This initElements method will create all WebElements
	        PageFactory.initElements(driver, this);
	    }
	    //Get the title of InboxPage
	        public String getInboxPageTitle(){
	         return inboxPageTitle.getText();
	        }
	}

