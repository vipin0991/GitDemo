import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Invokingwindow {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/RSAutomation/chromedriver.exe");
		
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		Set<String> s = driver.getWindowHandles();
		Iterator<String> st = s.iterator();
		String parent = st.next();
		String child = st.next();
		
		driver.switchTo().window(child);
		driver.navigate().to("https://rahulshettyacademy.com/");
		Thread.sleep(2000);
		String txt = driver.findElement(By.cssSelector("h2 a[href*='get-access-to-all-courses']")).getText();
		System.out.println(txt+"==");
		driver.switchTo().window(parent);
		WebElement e = driver.findElement(By.cssSelector("[name='name']"));
		e.sendKeys(txt);
		
		File f = e.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f,new File("D:/seleniumScreenshot/elementscreenshot.jpeg"));

}
}