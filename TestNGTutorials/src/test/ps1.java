package test;

import org.testng.annotations.Test;

public class ps1 extends ps {
	
	@Test
	public void testRun() {
		ps2 ob = new ps2(3); // Only PS2 class object is created and called methods of ps2 and ps3 classes via
		// this object. PS2 class extends PS3 class
		//defined values of variables defined in class ps2 and ps3 
		//using parameterized constructor, super, this keyword
		doThis();//No need to create object and directly call method by extending the class
		System.out.println(ob.increment());
		System.out.println(ob.decrement());
		System.out.println(ob.multiply());
	
	}
}
