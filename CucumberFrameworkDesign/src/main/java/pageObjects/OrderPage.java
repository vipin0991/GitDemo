package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
	
	WebDriver driver;
	
	@FindBy(css="[class='ng-star-inserted'] td:nth-of-type(2)") // at run time it will be constructed as driver.findElement(By.id("userEmail"))
	List<WebElement> li;
	//tbody [class='ng-star-inserted']
	//[class='ng-star-inserted'] td:nth-of-type(2)
	
	@FindBy(css="h1") 
	WebElement ordersListHeading;
	
	public OrderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public boolean ordersLst(String prod) {
		waitForElementToAppear(ordersListHeading);
		boolean val =  li.stream().anyMatch(s->s.getText().trim().equals(prod));
		return val;
			
	}

}
