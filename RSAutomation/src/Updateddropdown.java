import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Updateddropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/RSAutomation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Assert.assertEquals(driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).isSelected(), false);
		//System.out.println(driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).isSelected());
		
		//List<WebElement> li = driver.findElements(By.cssSelector("input[type='checkbox']"));
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		//System.out.println("before "+driver.findElement(By.id("Div1")).isEnabled());
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"));{
			System.out.println("Date is disabled");
			driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
			System.out.println("After "+driver.findElement(By.id("Div1")).isEnabled());
		}

		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		int i=1;
		while(i<5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		driver.close();
	}

}
