package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day3 {
	
	@Parameters({"URL","Key"})
	@Test
	public void dy3(String urlnm, String keynm) {
		System.out.println(urlnm);
		System.out.println(keynm);
	}
	
	@Test(dataProvider="getData")
	public void mobileSignOut(String nm, String pass) {
		System.out.println(nm+" "+pass);
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] obj = new Object[3][2];
		obj[0][0] = "firstname";
		obj[0][1] = "firstpass";
		obj[1][0] = "Secondname";
		obj[1][1] = "Secondpass";
		obj[2][0] = "Thirdname";
		obj[2][1] = "Thirdpass";
		return obj;
	}

}
