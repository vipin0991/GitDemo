
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridExecutionEdge {
	@Test
	public void HomePageCheck() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		//caps.setBrowserName("chrome");
		caps.setCapability(CapabilityType.BROWSER_NAME,"edge");
		
		WebDriver driver = new RemoteWebDriver(new URL("https://192.168.1.111:4444"),caps);
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		driver.close();
		
	}

}
