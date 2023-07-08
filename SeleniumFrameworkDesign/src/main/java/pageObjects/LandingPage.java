package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	@FindBy(id="userEmail") // at run time it will be constructed as driver.findElement(By.id("userEmail"))
	WebElement userEmail; // and will be assigned to this element.
	
	@FindBy(id="userPassword") 
	WebElement userPassword;
	
	@FindBy(xpath="//input[@value='Login']") 
	WebElement loginBtn;
	
	@FindBy(css="[class*='flyInOut']") 
	WebElement errorMessage;
	
	public ProductCatalogue login(String email, String pass) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(pass);
		loginBtn.click();
		ProductCatalogue pc = new ProductCatalogue(driver);
		return pc;
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String catchError(){
		waitForElementToAppear(errorMessage);
		return errorMessage.getText().trim();
		
	}
}
