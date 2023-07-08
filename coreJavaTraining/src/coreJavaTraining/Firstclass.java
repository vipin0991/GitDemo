package coreJavaTraining;

public class Firstclass {
	
	static int a = 4;
	
	int b = 3;
	
	String y = "name";
	int y=10;
	
	
	public void getData() {
		System.out.println("I am in getData method");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println(a+"==");
		System.out.println("Hello");
		
		Secondclass sc = new Secondclass();
		sc.setData();
		
		Firstclass fc = new Firstclass();
		fc.getData();
		System.out.println(fc.b);
		System.out.println(fc.y);

	}

}
