import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locator1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/RSAutomation/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("inputUsername")).sendKeys("vipin");
		//driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Vipin");
		driver.findElement(By.name("inputPassword")).sendKeys("test123");
		driver.findElement(By.className("signInBtn")).click();
		
		driver.manage().timeouts().implicitlyWait(12,TimeUnit.SECONDS);
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Vipin");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("vipin@gmail.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("updated@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9089786712");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(2000);
		//driver.close();
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
	}

}
