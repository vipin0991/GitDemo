import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3explicitwait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/RSAutomation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.cssSelector("input[value='user']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("okayBtn")).click();
		WebElement dp = driver.findElement(By.cssSelector("select.form-control"));
		Select d = new Select(dp);
		d.selectByVisibleText("Consultant");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		// //*[text()='ProtoCommerce Home']
		WebDriverWait w = new WebDriverWait(driver,5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='ProtoCommerce Home']")));
		
		int j=0;
		String[] brand= {"iphone","Samsung","Blackberry"};
		
		List brandList = Arrays.asList(brand);
		
		List<WebElement> prod = driver.findElements(By.cssSelector("h4[class='card-title'] a"));
		//System.out.println(prod);
		
		for(int i=0;i<prod.size();i++) {
			String[] pdNm = prod.get(i).getText().split(" ");
			if(brandList.contains(pdNm[0])) {
				driver.findElements(By.cssSelector(".btn.btn-info")).get(i).click();
				j++;
				if(j==brand.length) {
					break;
				}
			}
		}
		driver.findElement(By.cssSelector("a[class='nav-link btn btn-primary']")).click();
		
		
		
	}

}
