import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autosuggestion {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/RSAutomation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(1000);
		
		List<WebElement> li= driver.findElements(By.cssSelector("li[class='ui-menu-item']"));
		
		for(WebElement op : li) {
			//System.out.println(op.getText());
			if(op.getText().equals("India")) {
				op.click();
			}
		}
	}

}
