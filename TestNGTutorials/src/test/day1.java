package test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day1 {
	
	@Parameters({"URL"})
	@Test
	public void method(String url) {
		System.out.println(url);
		//Assert.assertTrue(false);
	}

}
