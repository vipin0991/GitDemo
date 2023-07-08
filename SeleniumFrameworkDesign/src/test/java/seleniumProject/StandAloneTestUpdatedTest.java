package seleniumProject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.Cart;
import pageObjects.Checkout;
import pageObjects.LandingPage;
import pageObjects.OrderPage;
import pageObjects.PlacedOrder;
import pageObjects.ProductCatalogue;

public class StandAloneTestUpdatedTest extends BaseTest {

	// String prod = "ADIDAS ORIGINAL";

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void submitOrder(HashMap<String, String> input) throws InterruptedException, IOException {
		// String prod = "ADIDAS ORIGINAL";
		String prod = input.get("product");
		ProductCatalogue pc = lp.login(input.get("email"), input.get("pass"));

		List<WebElement> li = pc.getProductList();
		pc.addProductToCart(prod);
		Cart ct = pc.navigateToCart();

		List<WebElement> crt = ct.getCartProductList();
		Boolean match = ct.checkCartItems(prod);
		Assert.assertTrue(match);

		Checkout chk = ct.clickCheckOut();

		PlacedOrder po = chk.enterCountry("india");

		String txt = po.placeOrder();

		Assert.assertEquals(txt, "THANKYOU FOR THE ORDER.");

	}

	String prodName = "zara coat 3";

	@Test(dependsOnMethods = { "submitOrder" })
	// @Test
	public void orderVerification() throws InterruptedException, IOException {
		ProductCatalogue pc = lp.login("vipin.dhiman21@gmail.com", "P@ssword!");
		OrderPage op = pc.navigateToOrders();
		// System.out.println(op.ordersLst(prod));
		Assert.assertEquals(op.ordersLst(prodName.toLowerCase()), true);

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		// 1st Way
		// return new Object[][] {{"vipin.dhiman21@gmail.com","P@ssword!","ZARA COAT
		// 3"},{"anshika@gmail.com","Iamking@000","ADIDAS ORIGINAL"}};
		// Another Way
//			HashMap<String, String> map = new HashMap<String, String>();
		// map.put("email","vipin.dhiman21@gmail.com");
		// map.put("pass","P@ssword!");
		// map.put("product","ZARA COAT 3");

//			HashMap<String, String> map1 = new HashMap<String, String>();
		// map1.put("email","anshika@gmail.com");
		// map1.put("pass","Iamking@000");
		// map1.put("product","ADIDAS ORIGINAL");
		List<HashMap<String, String>> data = getJsonDataToMap(
				"../SeleniumFrameworkDesign/src/test/java/data/PurchaseOrder.json");

		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}

}
