import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.openqa.selenium.support.locators.RelativeLocator.*;
//import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;


public class Relativelocator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/RSAutomation/chromedriver.exe");
		
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement e = driver.findElement(By.cssSelector("[name='name']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(e)).getText());
		driver.findElement(with(By.tagName("input")).below(driver.findElement(By.xpath("//label[text()='Date of Birth']")))).click();
		
		driver.findElement(with(By.tagName("input")).toLeftOf(driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']")))).click();
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(driver
				.findElement(By.id("inlineRadio1")))).getText());
		
	}

}
