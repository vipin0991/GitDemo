import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Windowscroll {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/RSAutomation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		int sum = 0;
		
		List<WebElement> li = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		for(int i=0;i<li.size();i++) {
			//System.out.println(li.get(i).getText());
			sum = sum+Integer.parseInt(li.get(i).getText());
		}
		String str = driver.findElement(By.cssSelector(".totalAmount")).getText();
		String [] ar = str.split(":");
		//System.out.println(ar[1].trim());
		Assert.assertEquals(Integer.parseInt(ar[1].trim()),sum);
		

	}

}
