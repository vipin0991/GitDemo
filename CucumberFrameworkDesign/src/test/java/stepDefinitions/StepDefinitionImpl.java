package stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Cart;
import pageObjects.Checkout;
import pageObjects.LandingPage;
import pageObjects.PlacedOrder;
import pageObjects.ProductCatalogue;

public class StepDefinitionImpl extends BaseTest {
	
	public LandingPage landingPage;
	public ProductCatalogue pc;
	public PlacedOrder po;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		landingPage = launchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")//(.+) this will automatically pick variable values from feature file
	public void Logged_in_with_username_and_password(String username, String password) throws IOException {
		pc = lp.login(username, password);
	}
	
	@When("^I add product (.+) to cart$")
	public void I_add_product_to_cart(String prod) {
		List<WebElement> li = pc.getProductList();
		pc.addProductToCart(prod);
	}
	@When("^Checkout (.+) and submit the order$")
	public void checkout_and_submit_the_order(String prod) throws InterruptedException {
		Cart ct = pc.navigateToCart();

		List<WebElement> crt = ct.getCartProductList();
		Boolean match = ct.checkCartItems(prod);
		Assert.assertTrue(match);

		Checkout chk = ct.clickCheckOut();

		po = chk.enterCountry("india");
	}
	 @Then("{string} message is displayed on ConfirmationPage.")
	 public void message_is_displayed_on_confirmationPage(String string) {
		 String confirmationMessage = po.placeOrder();
		Assert.assertEquals(confirmationMessage, string);
		driver.close();
	 }
	 @Then("{string} message is displayed.")
	 public void message_is_displayed(String string) {
			// String confirmationMessage = po.placeOrder();
			 Assert.assertEquals(string,lp.catchError());
			driver.close();
		 }
	
}
