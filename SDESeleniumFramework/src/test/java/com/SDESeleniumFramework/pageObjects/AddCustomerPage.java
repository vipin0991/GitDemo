package com.SDESeleniumFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how=How.LINK_TEXT, using="New Customer")
	WebElement newCustomer;
	
	@FindBy(how=How.NAME, using="name")
	WebElement name;
	
	@FindBy(how=How.XPATH, using="//input[@value='f']")
	WebElement gender;
	
	@FindBy(how=How.ID_OR_NAME, using="dob")
	WebElement dob;
	
	@FindBy(name="addr")
	WebElement address;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="pinno")
	WebElement pinno;
	
	@FindBy(name="telephoneno")
	WebElement telephoneno;
	
	@FindBy(name="emailid")
	WebElement emailid;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="sub")
	WebElement sub;
	
	public void navigateToAddCustomer() {
		newCustomer.click();
	}
	public void setCName(String uname) {
		name.sendKeys(uname);;
	}
	public void setCGender() {
		gender.click();
	}
	public void setCDOB(String DD, String MM, String YYYY) {
		dob.sendKeys(DD);
		dob.sendKeys(MM);
		dob.sendKeys(YYYY);
	}
	public void setCAddress(String addr) {
		address.sendKeys(addr);
	}
	public void setCCity(String cty) {
		city.sendKeys(cty);
	}
	public void setCState(String st) {
		state.sendKeys(st);
	}
	public void setCPin(String pin) {
		pinno.sendKeys(String.valueOf(pin));
	}
	public void setCMobile(String mobile) {
		telephoneno.sendKeys(mobile);
	}
	public void setCEmail(String email) {
		emailid.sendKeys(email);
	}
	public void setCPassword(String pass) {
		password.sendKeys(pass);
	}
	public void clickSubmit() {
		sub.click();
	}
	
	
	
}
