package test;

public class ps2 extends ps3 {

	int a;
	public ps2(int i) {
		// TODO Auto-generated constructor stub
		super(i);
		this.a = i;
	}
	
	public int increment() {
		a=a+1;
		return a;	
	}
	public int decrement() {
		a=a-1;
		return a;	
	}

}
