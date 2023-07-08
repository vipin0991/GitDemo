package Fremwork.SeleniumLatestFeature;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
import org.openqa.selenium.devtools.v85.emulation.model.ScreenOrientation;
import org.openqa.selenium.devtools.v85.page.model.Viewport;
//import org.openqa.selenium.devtools.v95.emulation.model.DisplayFeature;

import io.github.bonigarcia.wdm.WebDriverManager;



public class MobileEmulator {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method 
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(ops);
		
		DevTools devtool = driver.getDevTools();
		devtool.createSession();
		devtool.send(Emulation.setDeviceMetricsOverride(700, 1000, 50, true, Optional.<Number> empty(),
	            Optional.<Integer> empty(), Optional.<Integer> empty(), Optional.<Integer> empty(), 
	            Optional.<Integer> empty(), Optional.<Boolean> empty(), Optional.<ScreenOrientation> empty(), 
	          Optional.<Viewport> empty()));
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo");
		driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Library")).click();
	}

}
