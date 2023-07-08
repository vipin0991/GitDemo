import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class e2e {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/RSAutomation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(1000);
		// To select From City
		driver.findElement(By.xpath("//a[@text='Delhi (DEL)']")).click();
		// driver.findElement(By.xpath("//a[@text='Bengaluru (BLR)']")).click;
		Thread.sleep(2000);
		// To select To city
		driver.findElement(
				By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@text='Chennai (MAA)']"))
				.click();
		// To select current Date
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		// To select 5 passengers
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		int i = 1;
		while (i < 5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		// To select currency
		WebElement e = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(e);
		dropdown.selectByIndex(3);
		Thread.sleep(1000);
		// To check senior Citizen check box;
		driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).click();
		Thread.sleep(1000);
		// To click on Search
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

	}

}
