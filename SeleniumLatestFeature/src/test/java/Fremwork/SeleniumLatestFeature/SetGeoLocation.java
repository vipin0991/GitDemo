package Fremwork.SeleniumLatestFeature;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;

public class SetGeoLocation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		System.setProperty("Webdriver.driver.chrome", "../SeleniumLatestFeature/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(ops);
		
		DevTools devtool = driver.getDevTools();
		devtool.createSession();
		Map<String, Object>coordinates= new HashMap<String, Object>();
		
		coordinates.put("latitude",40);
		coordinates.put("longitude",3);
		coordinates.put("accuracy",1);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		Thread.sleep(2000);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		System.out.println(driver.findElement(By.tagName("h1")).getText());
	}

}
