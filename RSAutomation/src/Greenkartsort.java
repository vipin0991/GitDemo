import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Greenkartsort {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/RSAutomation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.findElement(By.xpath("//*[text()='Top Deals']")).click();

		Set<String> sv = driver.getWindowHandles();
		Iterator<String> st = sv.iterator();
		String parent = st.next();
		String child = st.next();
		driver.switchTo().window(child);

		// click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		// capture all webelements into list
		List<WebElement> li = driver.findElements(By.xpath("//tr/td[1]"));
		// capture text of all webelements into new(original) list
		
		  List<String> original =
		  li.stream().map(s1->s1.getText()).collect(Collectors.toList()); 
		  // sort on the original list of step 3 -> sorted list 
		  List<String> originalUpdated =
		  li.stream().map(s1->s1.getText()).sorted().collect(Collectors.toList()); 
		  // compare original list vs sorted list 
		  // Assert.assertEquals(original,originalUpdated); 
		  Assert.assertTrue(original.equals(originalUpdated));
		 

		List<String> price;
		do {
		List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
		Thread.sleep(2000);
		price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPrice(s))
				.collect(Collectors.toList());
		// price = rows.stream()
		// .map(s->getPrice(s)).collect(Collectors.toList());
		if(price.size()<1) {
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
		}}while(price.size()<1);
		

		price.forEach(a -> System.out.println(a));

		driver.findElement(By.cssSelector("input[id='search-field']")).sendKeys("Beans");
		List<WebElement> e = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		List<WebElement> filtered = e.stream().filter(s->s.getText().contains("Beans")).collect(Collectors.toList());
		Assert.assertEquals(e.size(),filtered.size());
	}

	private static String getPrice(WebElement s) {
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		// System.out.println(priceValue);
		return priceValue;
	}

}
