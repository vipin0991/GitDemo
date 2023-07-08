package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstractComponents.AbstractComponent;

public class PlacedOrder extends AbstractComponent {

	WebDriver driver;
	public PlacedOrder(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}


	@FindBy(css="[class='hero-primary']") 
	WebElement heading;
	
	By msg = By.cssSelector("[class='hero-primary']");

	
	public String placeOrder() {
		waitForElementToAppear(msg);
		return heading.getText().trim();
	
	}

}
