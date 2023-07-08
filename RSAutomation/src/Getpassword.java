import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Getpassword {
	static String pwd;
	static String name = "vipin";

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","/RSAutomation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Getpassword obj = new Getpassword();
		pwd = obj.login(driver);
		
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(pwd);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		driver.close();
	}
	
	public String login(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String str = driver.findElement(By.cssSelector("form p")).getText();
		String[] txt = str.split("'");
		return txt[1];
	}

}
