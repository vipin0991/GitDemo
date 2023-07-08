package coreJavaTraining;

public class reversedemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "aryan";
		String rev = "";
		int a = s.length()-1;
		
		for(int i=a;i>=0;i--) {
			rev = rev+s.charAt(i);
		}
		if(s.equals(rev))		
		System.out.println("palindrome");
		else
			System.out.println("Not palindrome");
	}

}
