package com.SDESeleniumFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(name="uid")
	WebElement name;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement loginBtn;
	
	public void setUsername(String username) {
		name.sendKeys(username);
	}
	public void setPassword(String Password) {
		password.sendKeys(Password);
	}
	public void clickLogin() {
		loginBtn.click();
	}
	
	
}