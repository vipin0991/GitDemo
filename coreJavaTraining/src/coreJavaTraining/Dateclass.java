package coreJavaTraining;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Dateclass {
	
	public static void main(String[] args) {
		Date dt = new Date();
		System.out.println(dt.toString());
		
		SimpleDateFormat sdf = new SimpleDateFormat("M/d/YYYY");
		System.out.println(sdf.format(dt));
		
		//MM/DD/YYYY
	}

}
