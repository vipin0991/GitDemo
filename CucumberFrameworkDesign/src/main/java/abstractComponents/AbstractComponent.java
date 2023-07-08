package abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.Cart;
import pageObjects.OrderPage;

public class AbstractComponent {
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	By cartLink = By.cssSelector("button[routerlink*='cart']");
	
	@FindBy(css="button[routerlink*='cart']") 
	WebElement cart;
	
	@FindBy(css="[routerlink*='myorders']") 
	WebElement ordersList;

	public void waitForElementToAppear(By findBy) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-body")));	
	}
	
	public void waitForElementToAppear(WebElement e) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(e));
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-body")));	
	}
	
	public void waitForElementToDisAppear(WebElement e) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.invisibilityOf(e));
	}
	
	public Cart navigateToCart() {
		waitForElementToAppear(cartLink);
		cart.click();
		Cart ct = new Cart(driver);
		return ct;
	}
	
	public OrderPage navigateToOrders() {
		waitForElementToAppear(ordersList);
		ordersList.click();
		OrderPage op = new OrderPage(driver);
		return op;
	}
	
	
}
