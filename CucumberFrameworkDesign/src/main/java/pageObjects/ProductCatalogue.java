package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

	WebDriver driver;
	public ProductCatalogue(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	//List<WebElement> li = driver.findElements(By.cssSelector(".card-body"));
	@FindBy(css=".card-body") // at run time it will be constructed as driver.findElement(By.id("userEmail"))
	List<WebElement> li; // and will be assigned to this element.
	
	@FindBy(css=".ng-animating") 
	WebElement spinner;
	
	By productsBy = By.cssSelector(".card-body");
	By prodLoad	=	By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.id("toast-container");


	
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return li;
	}
	
	public WebElement getProductByName(String prodName) {
		WebElement e = getProductList().stream().filter(s->s.findElement(By.cssSelector("b")).getText()
				.equals(prodName))
				.findFirst()
				.orElse(null);
		return e;
	}
	public void addProductToCart(String prodName) {
		waitForElementToAppear(prodLoad);
		WebElement prod = getProductByName(prodName);
				prod.findElement(prodLoad).click();
				waitForElementToAppear(toastMessage);
				waitForElementToDisAppear(spinner);
	}


}
