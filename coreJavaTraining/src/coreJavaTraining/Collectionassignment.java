package coreJavaTraining;

import java.util.ArrayList;

public class Collectionassignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> ar = new ArrayList<Integer>();

		int a[] = {4,5,5,5,4,6,6,9,4};
	
		
		for(int i=0;i<a.length;i++) {
			int k = 0;
			if(!ar.contains(a[i])) {
				ar.add(a[i]);
				k++;
				for(int j=i+1;j<a.length;j++) {
					if(a[i]==a[j]) {
						k++;
					}
				}
				System.out.println(a[i]+" count "+ k);
				if(k==1)
					System.out.println(a[i] + " is unique");
			}
			
		}
	}

}
