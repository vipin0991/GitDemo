package seleniumProject;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		WebDriverWait w = new WebDriverWait(driver, 30);
		//Hit URL
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		
		String prod = "ADIDAS ORIGINAL";
		
		//Enter email & Password then login
		driver.findElement(By.id("userEmail")).sendKeys("vipin.dhiman21@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("P@ssword!");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		//Search for a specific product and then click on add to cart
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-body")));		
		List<WebElement> li = driver.findElements(By.cssSelector(".card-body"));
				//w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("b")));
		WebElement e = li.stream().filter(s->s.findElement(By.cssSelector("b")).getText()
								.equals(prod))
								.findFirst()
								.orElse(null);
		//System.out.println(e.getText());		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-body button:last-of-type")));
		e.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		//Check display of message that product is added to the cart
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		//Check invisibility of grey screen.
		w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		//w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		
		//check availability of cart link and then click on it
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[routerlink*='cart']")));
		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart")));
	
		//Check if cart items are same as like product added
		List<WebElement> cartItems = driver.findElements(By.cssSelector("[class='cartSection'] h3"));
		Boolean match = cartItems.stream().anyMatch(s->s.getText().trim().equals(prod));
		
		//check availability of checkout button and then click on it
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".totalRow .btn.btn-primary")));
		driver.findElement(By.cssSelector(".totalRow .btn.btn-primary")).click();
		
		//provide country value and then click on place order
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder='Select Country']")));
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='ng-star-inserted']")));
		
		driver.findElement(By.cssSelector("button[class*='ta-item']:nth-child(3)")).click();
		
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("window.scrollBy(0,400)");
		
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".action__submit")).click();
		//Verify thank you message in the last page
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='hero-primary']")));
		String h1 =  driver.findElement(By.cssSelector("[class='hero-primary']")).getText().trim();
		Assert.assertEquals(h1,"THANKYOU FOR THE ORDER.");
		driver.close();
		
	}	

}
