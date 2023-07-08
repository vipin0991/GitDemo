package coreJavaTraining;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Arraylistclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> a= new ArrayList<String>();
		a.add("Vipin");
		a.add("Anand");
		System.out.println(a);
		a.add(0, "Sudhir");
		System.out.println(a);
		/*a.remove(0);
		System.out.println(a);*/
		System.out.println(a.get(2));
		System.out.println(a.contains("Vipin"));
		
		HashMap<Integer, String> hp = new HashMap<Integer, String>();
		hp.put(1, "CHD");
		hp.put(12, "Mohali");
		hp.put(23, "ERT");
		
		Set<Integer> s = hp.keySet();
		for(Integer i : s) {
			System.out.println("Key is "+i+" Value is "+hp.get(i));
		}
		System.out.println("============");
		
		Set s2 = hp.entrySet();
		Iterator it = s2.iterator();
		while(it.hasNext()) {
			Map.Entry mp	= (Map.Entry)it.next();
		//System.out.println(it.next());
			System.out.println(mp.getKey()+" "+mp.getValue());
		}
		
		

	}

}
