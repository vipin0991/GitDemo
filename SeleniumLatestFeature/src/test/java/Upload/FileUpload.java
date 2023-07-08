package Upload;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		String path = System.getProperty("user.dir");
		Map<String, Object> config = new HashMap<String, Object>();
		config.put("profile.default_content_settings.popups", 0);
		config.put("download.default_directory", path);
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		ops.setExperimentalOption("prefs",config);
		
		System.setProperty("webdriver.chrome.driver","../SeleniumLatestFeature/chromedriver.exe");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("https://altoconvertpdftojpg.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(".file_browse")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\91904\\Downloads\\autoIT\\filePath.exe");
		Thread.sleep(3000);
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,500)");
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(15));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit_btn")));
		driver.findElement(By.id("submit_btn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fa-download")));
		driver.findElement(By.cssSelector(".fa-download")).click();
		System.out.println(path+"\\hi.jpg");
		File f = new File(path+"\\hi.jpg");
		Thread.sleep(3000);
		if(f.exists()) {
			System.out.println("FILE IS FOUND");
			f.delete();
		}
	}

}
