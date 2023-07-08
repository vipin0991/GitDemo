package Fremwork.SeleniumLatestFeature;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.fetch.Fetch;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Request;

public class NetworkMocking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		System.setProperty("Webdriver.driver.chrome", "../SeleniumLatestFeature/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(ops);

		DevTools devtool = driver.getDevTools();
		devtool.createSession();
		devtool.send(Fetch.enable(Optional.empty(), Optional.empty()));
		devtool.addListener(Fetch.requestPaused(), request -> {
			if (request.getRequest().getUrl().contains("shetty")) {
				System.out.println(request.getRequest().getUrl());
				String mockedUrl = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				//System.out.println(mockedUrl);
				devtool.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockedUrl),
						Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty()));

			}
			else {
				devtool.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()), Optional.of(request.getRequest().getMethod()),
						Optional.empty(), Optional.empty()));

			}
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		Thread.sleep(3000);
		
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
	}
}
