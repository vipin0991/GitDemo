
public class ImplementInterface implements interfaceNew {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(interfaceNew.num);
		
		interfaceNew a = new ImplementInterface();
		interfaceNew.display();
		a.engine();
		
		interfaceNew a1 = new ImplementInterface();
		a1.display();

	}

	@Override
	public void engine() {
		// TODO Auto-generated method stub
		System.out.println("My Engine");
	}

}