import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Dynamicdropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	
		
		System.setProperty("webdriver.chrome.driver","/RSAutomation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		
		driver.findElement(By.xpath("//input[contains(@class,'r-10paoce')]")).click();
		driver.findElement(By.xpath("//div[text()='KQH']")).click(); //Ajmer
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='IXG']")).click(); //Belagavi
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
	}

}
