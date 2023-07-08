import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridExecution {
	
	@Test
	public void HomePageCheck() {
		System.out.println("hi");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("chrome");
		//System.out.println("hi");
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.111:4444/wd/hub"), caps);
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Vipin Dhiman");
		driver.close(); 
		
	}

}
