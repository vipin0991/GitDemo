package com.SDESeleniumFramework.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.SDESeleniumFramework.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	
	@Test
	public void login() {
		logger.info("URL is opened");
		LoginPage lp =  new LoginPage(driver);
		lp.setUsername(uName);
		lp.setPassword(Password);
		logger.info("Login details are entered");
		lp.clickLogin();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			logger.info("Login test passed");
			Assert.assertTrue(true);
		}else {
			logger.info("Login test failed");
			Assert.assertFalse(true);
			
		

	}
	
}
}

