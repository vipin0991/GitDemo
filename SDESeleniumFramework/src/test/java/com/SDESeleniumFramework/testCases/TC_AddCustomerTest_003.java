package com.SDESeleniumFramework.testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SDESeleniumFramework.pageObjects.AddCustomerPage;
import com.SDESeleniumFramework.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addCustomer() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		logger.info("URL is opened");
		lp.setUsername(uName);
		lp.setPassword(Password);
		logger.info("Provided credentials");
		lp.clickLogin();
		//Thread.sleep(2000);
		logger.info("Home Page is displayed");
		AddCustomerPage ac = new AddCustomerPage(driver);
		
		ac.navigateToAddCustomer();
		logger.info("Click on New Customer link");
		Thread.sleep(3000);

        WebElement frame1 = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
        driver.switchTo().frame(frame1);
        
        WebElement fr2 = driver.findElement(By.id("ad_iframe"));
		driver.switchTo().frame(fr2);
        
		//Check if any frame exists or not
		List<WebElement> iframes = driver.findElements(By.xpath("//div[@aria-label='Close ad']"));
		//List<WebElement> iframes = driver.findElements(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));// return 1 when no popup or popup
		//List<WebElement> iframes = driver.findElements(By.xpath("//span[normalize-space()='Close']"));//as above
		////div[@id='dismiss-button']//span[normalize-space()='Close'] as above
		//If frame exist that will be related to google adds
		System.out.println("Frame Count "+iframes.size());
		if (iframes.size() > 0) {
			
			

			//WebElement fr2 = driver.findElement(By.id("ad_iframe"));
			//driver.switchTo().frame(fr2);
			driver.findElement(By.xpath("//div[@id='dismiss-button']//span[normalize-space()='Close']")).click();
			driver.switchTo().defaultContent();
			logger.info("Handled Google add on popup");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("Start entering differnet attribute values");
		ac.setCName("Sumit Vaid");
		
		ac.setCGender();
		ac.setCDOB("12", "09", "1988");
		ac.setCAddress("Huda colony Sonipat");
		ac.setCCity("Sonipat");
		ac.setCState("Haryana");
		ac.setCPin("1234321");
		ac.setCMobile("9876543210");
		ac.setCEmail("sumit."+randomString()+"@gmail.com");
		ac.setCPassword("1234sumit");
		logger.info("Click on Submit");
		ac.clickSubmit();
		
		//String e = ;
		if(driver.findElement(By.className("heading3")).getText().contains("Customer Registered Successfully!!!")) {
			logger.info("TC Passed");
			Assert.assertTrue(true);
		}else {
			logger.info("TC Failed");
			Assert.assertTrue(false);
		}
	}
}
