package com.SDESeleniumFramework.testCases;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.SDESeleniumFramework.utilities.readConfig;

public class BaseClass {
	
	public WebDriver driver;
	
	readConfig rc = new readConfig();
	
	public String baseURL = rc.getUrl() ;
	public String uName = rc.getName();
	public String Password = rc.getPassword() ;
	public Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void launchBrowser(String br) {
		if(br.equals("chrome")) {
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");
			
			System.setProperty("webdriver.chrome.driver", rc.getChromPath());
			driver = new ChromeDriver(ops);
		}
		else if(br.equals("edge")){
			EdgeOptions ops = new EdgeOptions();
			ops.addArguments("--remote-allow-origins=*");
			System.setProperty("webdriver.edge.driver", rc.getEdgePath());
			driver = new EdgeDriver(ops);
		}
	
		driver.manage().window().maximize();
		
		logger = Logger.getLogger("Selenium");
		PropertyConfigurator.configure("log4j.properties");
		
		driver.get(baseURL);

	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

	public String captureScreenshot(WebDriver driver) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//System.out.println(System.getProperty("user.dir"));
		String target = System.getProperty("user.dir")+"\\Screenshots\\"+System.currentTimeMillis()+".jpg";
		FileUtils.copyFile(src, new File("../SDESeleniumFramework/Screenshots/"+System.currentTimeMillis()+".jpg"));
		return target;
	}
	
	public String randomString() {
		String ran = RandomStringUtils.randomAlphabetic(4);
		return ran;
	}
	
}
