import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webdriverscope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/RSAutomation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement e = driver.findElement(By.id("gf-BIG"));
		System.out.println(e.findElements(By.tagName("a")).size());
		
		WebElement subfooter = driver.findElement(By.xpath("//table[@class='gf-t'] //td[1]/ul"));
		int count = subfooter.findElements(By.tagName("a")).size();
		for(int i=1;i<count;i++) {
			String clickOnLinks = Keys.chord(Keys.CONTROL,Keys.ENTER);
			subfooter.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinks);
			Thread.sleep(2000);
		}
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		while(iterator.hasNext()) {
			driver.switchTo().window(iterator.next());
			System.out.println(driver.getTitle());
			
		}
		
		
	}

}
