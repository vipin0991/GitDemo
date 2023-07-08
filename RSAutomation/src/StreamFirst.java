import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamFirst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> names = new ArrayList<String>();
		names.add("Vipin");
		names.add("Vikas");
		names.add("Vibhor");
		names.add("Ajay");
		names.add("Vinay");
		
		names.stream().filter(s->s.startsWith("V")).forEach(s->System.out.println(s));
		
		Stream.of("Sourabh","Sumit","Bharat","Manish","Robin").filter(s->s.startsWith("S")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		Stream.of("Sourabh","Sumit","Bharat","Manish","Robin").filter(s->s.endsWith("t")).map(s->s.toUpperCase())
		.forEach(s->System.out.println("=="+s+"=="));
	


	}

}
