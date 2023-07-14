package com.SDESeleniumFramework.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SDESeleniumFramework.pageObjects.HomePage;
import com.SDESeleniumFramework.pageObjects.LoginPage;
import com.SDESeleniumFramework.utilities.XLUtils;

public class TC_LoginDDTTest_002 extends BaseClass {

	@Test(dataProvider = "driveTest")
	public void loginTest(String sUsername, String sPassword) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(sUsername);
		lp.setPassword(sPassword);
		logger.info("Login details are entered");
		lp.clickLogin();
		Thread.sleep(3000);
		

		if(isAlertPresent()==true) {
			//To check if alert present, accept it in case of invalid credentials.
			logger.warn("Password is invalid");
			  driver.switchTo().alert().accept();
			  driver.switchTo().defaultContent();
		      Assert.assertTrue(false);
		}else {
			//To check if alert not present, Logout and accept alert then
			logger.info("Password is valid");
			HomePage hp = new HomePage(driver);
			hp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
		}
		
	}
	
	@DataProvider(name = "driveTest")
	public String[][] getData() throws IOException{
		String path = "../SDESeleniumFramework/src/test/java/com/SDESeleniumFramework/testData/LoginData.xlsx";
		
		int rowCount = XLUtils.getRowCount(path, "Sheet1");
		int cellCount = XLUtils.getCellCount(path, "Sheet1", rowCount);
		
		
		String LoginData[][] = new String[rowCount][cellCount];
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				LoginData[i-1][j] = 	XLUtils.getCellData(path, "Sheet1", i,j);
			}
		}
		return LoginData;
	}
	
	//To check if alert is present or not
	public boolean isAlertPresent() 
	{ 
	    try 
	    { 
	        driver.switchTo().alert();
	        return true; 
	    }   // try 
	    catch (Exception Ex) 
	    { 
	        return false; 
	    }   // catch 
	}
	
}
