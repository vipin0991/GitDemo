import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class WebtableAssignment1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/RSAutomation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> li = driver.findElements(By.cssSelector("ul[id='ui-id-1'] li"));
		System.out.println(li.size()+"==");
		for(int i=0;i<li.size();i++) {
			if(driver.findElements(By.cssSelector("ul[id='ui-id-1'] li")).get(i).getText().equals("India")) {;
				driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
				break;	
			}
			else {
				driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
			}
		}
		
		Assert.assertEquals(driver.findElement(By.id("autocomplete")).getAttribute("value"),"India");		
		
	}

}
