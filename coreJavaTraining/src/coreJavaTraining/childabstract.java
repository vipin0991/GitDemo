package coreJavaTraining;

public class childabstract extends Parentabstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		childabstract ca = new childabstract();
		ca.logo();
		ca.safetyRules();
		

	}

	@Override
	public void logo() {
		// TODO Auto-generated method stub
		System.out.println("logo method");
		
	}
	
	public void safetyRules() {
		System.out.println("safetyrules");
	}
	
	

}
