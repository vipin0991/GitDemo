package coreJavaTraining;

public class Stringclassdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "JavaTraining";
		
		System.out.println(s.charAt(3));
		System.out.println(s.indexOf('T'));
		System.out.println(s.substring(4, 10));
		System.out.println(s.substring(4));
		System.out.println(s.concat(" by self"));
		System.out.println(s.replace('T', 't'));
		
		String a[] = s.split("T");
		System.out.println(a[0]);
		System.out.println(a[1]);
		

	}

}
