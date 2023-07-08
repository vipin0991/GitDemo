import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowhandles {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/RSAutomation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.className("blinkingText")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		String parent = iterator.next();
		String child = iterator.next();
		driver.switchTo().window(child);
		
		Thread.sleep(2000);
		String email = driver.findElement(By.xpath("//*[text()='mentor@rahulshettyacademy.com']")).getText();
		/*String[] ar = text.split(" ");
		String email = "";
		for(int i=0;i<ar.length;i++) {
			if(ar[i].contains("mentor@rahulshettyacademy.com")) {
				email = ar[i];
				break;
			}
		}*/
		driver.switchTo().window(parent);
		driver.findElement(By.id("username")).sendKeys(email);
	}

}
