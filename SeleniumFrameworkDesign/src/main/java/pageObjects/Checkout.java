package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class Checkout extends AbstractComponent {

	WebDriver driver;
	public Checkout(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	//List<WebElement> li = driver.findElements(By.cssSelector(".card-body"));
	@FindBy(css="button[class*='ta-item']:nth-child(3)") // at run time it will be constructed as driver.findElement(By.id("userEmail"))
	WebElement selectOption; // and will be assigned to this element.
	
	@FindBy(css="[placeholder='Select Country']") // at run time it will be constructed as driver.findElement(By.id("userEmail"))
	WebElement country; 
	
	@FindBy(css=".action__submit")
	WebElement placeOrder;
	
	By placeholder = By.cssSelector("[placeholder='Select Country']");
	By options = By.cssSelector("span[class='ng-star-inserted']");

	
	public PlacedOrder enterCountry(String countryName) throws InterruptedException {
		waitForElementToAppear(placeholder);
		Actions a = new Actions(driver);
		a.sendKeys(country,countryName).build().perform();
		waitForElementToAppear(options);
		selectOption.click();
		
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("window.scrollBy(0,400)");
		  
		  Thread.sleep(2000);
		  placeOrder.click();
		  return new PlacedOrder(driver);
		 
	}

}
