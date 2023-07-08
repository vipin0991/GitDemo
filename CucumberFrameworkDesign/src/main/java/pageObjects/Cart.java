package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class Cart extends AbstractComponent {

	WebDriver driver;
	public Cart(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="[class='cartSection'] h3") // at run time it will be constructed as driver.findElement(By.id("userEmail"))
	List<WebElement> crt;
	
	@FindBy(css=".totalRow .btn.btn-primary") 
	WebElement checkOut;

	By cartItem = By.cssSelector(".cart");
	By mainCart = By.cssSelector("[class='cartSection'] h3");
	By chkOut = By.cssSelector(".totalRow .btn.btn-primary");
	
	public List<WebElement> getCartProductList() {
		waitForElementToAppear(mainCart);
		return crt;
	}
	
	public boolean checkCartItems(String prodName) {
		waitForElementToAppear(cartItem);
		//Boolean match = getCartProductList().stream().anyMatch(s->s.getText().trim().equals(prodName));
		Boolean match = crt.stream().anyMatch(s->s.getText().trim().equals(prodName));
		waitForElementToAppear(chkOut);
		return match;

	}
	public Checkout clickCheckOut() {
		//waitForElementToAppear(chkOut);
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("window.scrollBy(0,400)");
		checkOut.click();
		Checkout chk = new Checkout(driver);
		return chk;
	}
	


}
