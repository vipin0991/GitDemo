package Fremwork.SeleniumLatestFeature;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CdpCommandsTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver","../SeleniumLatestFeature/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(ops);
		
		DevTools devtool = driver.getDevTools();
		devtool.createSession();
		Map<String, Object> deviceMetrics = new HashMap<String, Object>();
		
		deviceMetrics.put("width",600);
		deviceMetrics.put("height",1000);
		deviceMetrics.put("deviceScaleFactor",50);
		deviceMetrics.put("mobile",true);
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
		driver.get("https://rahulshettyacademy.com/angularAppdemo");
		driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Library")).click();
		
	}

}
