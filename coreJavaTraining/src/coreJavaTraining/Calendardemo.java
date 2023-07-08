package coreJavaTraining;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Calendardemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("M/d/YYYY hh:mm:ss");
		
		System.out.println(sdf.format(cal.getTime()));

	}

}
