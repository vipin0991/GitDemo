import java.text.SimpleDateFormat;
import java.util.Date;

public class DateClass {
	public static void main(String[] args) {
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
		System.out.println(dt.getDate());
		System.out.println(dt);
		System.out.println(sdf.format(dt));
	}
}
