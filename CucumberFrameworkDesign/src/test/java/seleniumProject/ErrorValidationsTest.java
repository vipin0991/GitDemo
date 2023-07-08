package seleniumProject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import TestComponents.Retry;
import pageObjects.Cart;
import pageObjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {
		
		@Test(retryAnalyzer=Retry.class)
		public void verifyInvalidLogin() throws InterruptedException, IOException {
		lp.login("vipin.dhiman21@gmail.com","P@ssword3!");
		
		Assert.assertEquals("Incorrect email or password.",lp.catchError());

}	

		//@Test(groups={"ErrorHandling"})
		@Test
		public void verifyProductInCart(){
			
			ProductCatalogue pc = lp.login("vipin.dhiman21@gmail.com","P@ssword!");
			
			List<WebElement> li = pc.getProductList();
			String prod = "ADIDAS ORIGINAL";
			pc.addProductToCart(prod );
			Cart ct = pc.navigateToCart();

			List<WebElement> crt = ct.getCartProductList();
			Boolean match = ct.checkCartItems("ADIDAS ORIGINAL 3");
			Assert.assertFalse(match);

	}

}
