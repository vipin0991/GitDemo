import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Brokenlinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/RSAutomation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert a =  new SoftAssert();
		
		for(WebElement e : links) {
			String val = e.getAttribute("href");
			
			HttpURLConnection conn = (HttpURLConnection)new URL(val).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			
			//System.out.println(conn.getResponseCode());
			/*if(conn.getResponseCode()>400) {
				System.out.println(e.getText()+" "+conn.getResponseCode() );
			}*/
			a.assertTrue(conn.getResponseCode()<400, "The link "+e.getText()+" is broken "+conn.getResponseCode());
		}
		a.assertAll();
		
	}

}
