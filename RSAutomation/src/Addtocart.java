import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Addtocart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/RSAutomation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/"); 
		
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//Stored products in the list which need to be added
		String[] prod = {"Cucumber","Brocolli","Beans","Pumpkin"};
		
		WebDriverWait w = new WebDriverWait(driver,5);
		
		addItems(driver,prod,w);
		
	}
	
	public static void addItems(WebDriver driver,String[] prod,WebDriverWait w ) {
		
		int j=0;

		List<String> itemsNeeded = Arrays.asList(prod);
		
		//Grab all products name.
		List<WebElement> li = driver.findElements(By.cssSelector(".product-name"));
		
		for(int i=0;i<li.size();i++) {
			String[] nm = li.get(i).getText().split("-");
			
			//check whether name we extracted is present in ArrayList or not
			if(itemsNeeded.contains(nm[0].trim())) {
			//driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
			driver.findElements(By.cssSelector("div[class='product-action'] button")).get(i).click();
				//Thread.sleep(5000);
			j++;
			if(j==itemsNeeded.size()) {
				break;
			}
			}
		}
		driver.findElement(By.cssSelector("a[class='cart-icon'] img")).click();
		
		driver.findElement(By.cssSelector("div[class='action-block'] button")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	}

}
