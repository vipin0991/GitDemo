
public class ExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			try {
				int i=4;
				int j=0;
				System.out.println(i/j);
			}
			catch(Exception e) {
				System.out.println("exception caught");
			}
	}

}
