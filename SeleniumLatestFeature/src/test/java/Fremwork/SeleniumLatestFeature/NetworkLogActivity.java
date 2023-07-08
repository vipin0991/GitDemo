package Fremwork.SeleniumLatestFeature;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.model.Request;
import org.openqa.selenium.devtools.v85.network.model.Response;
import org.openqa.selenium.devtools.v85.network.Network;

public class NetworkLogActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		System.setProperty("Webdriver.driver.chrome", "../SeleniumLatestFeature/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(ops);
		
		DevTools devtool = driver.getDevTools();
		devtool.createSession();
		devtool.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devtool.addListener(Network.requestWillBeSent(), request ->
		{
			Request req = request.getRequest();
			//System.out.println(req.getUrl());
		});
		
		devtool.addListener(Network.responseReceived(), response ->
		{
			Response res = response.getResponse();
			//System.out.println(res.getUrl());
			if(res.getStatus().toString().startsWith("4")) {
				System.out.println(res.getUrl());
			}
			System.out.println(res.getStatus());
		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	}

}
