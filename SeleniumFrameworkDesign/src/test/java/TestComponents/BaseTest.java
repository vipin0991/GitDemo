package TestComponents;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage lp;
	
	public WebDriver initializeDriver() throws IOException
	{
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream("../SeleniumFrameworkDesign/src/main/java/resources/GlobalData.properties");
		//FileInputStream fis = new FileInputStream("D:/Selenium/workspace/SeleniumFrameworkDesign/src/main/java/resources/GlobalData.properties");
		p.load(fis);
		
		String browserName = System.getProperty("browser")!=null?System.getProperty("browser"):p.getProperty("browser");
	//	String browserName = p.getProperty("browser");
		//if(browserName.equalsIgnoreCase("chrome")) {
		if(browserName.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");
			if(browserName.contains("headless")) {
				ops.addArguments("headless");
			}
			
			driver = new ChromeDriver(ops);
		//	driver.manage().window().setSize(new Dimension(1440,900));
			driver.manage().window().setSize(new org.openqa.selenium.Dimension(1440, 900));
			
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "../SeleniumFrameworkDesign/geckodriver");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "edge.exe");
			driver = new EdgeDriver();
		}
		WebDriverWait w = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		return driver;
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		//read json to string
		String jsonContent = FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {
		driver = initializeDriver();
		lp = new LandingPage(driver);
		lp.goTo();
		return lp;
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser() {
		driver.close();
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".jpeg");
		FileUtils.copyFile(src, dest);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".jpeg";
	}
}
