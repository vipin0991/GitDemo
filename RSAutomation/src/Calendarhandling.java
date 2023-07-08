import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendarhandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/RSAutomation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companion/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		driver.findElement(By.name("form_fields[travel_comp_date]")).click();
		
		while(!driver.findElement(By.cssSelector(".flatpickr-month")).getText().contains("August")) {
			Thread.sleep(500);
			driver.findElement(By.xpath("//span[@class='flatpickr-next-month'] //*[local-name()='svg']")).click();
		}
		
		List<WebElement> li = driver.findElements(By.xpath("//span[@class='flatpickr-day ']"));
		for(int i=1;i<li.size();i++) {
			 //String text=driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).getText();
			Thread.sleep(1000);
			if(driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).getText().equalsIgnoreCase("18")) {
			  driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).click();
				break;
			}
		}		
		
	}

}
