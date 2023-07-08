package coreJavaTraining;

public class Sortarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int temp;
		int a[] = {2,6,1,4,9};
		temp = a[0];
		
		for(int i=0;i<a.length;i++){
			for(int j=i+1;j<a.length;j++)
			if(a[i]>a[j]) {
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
			
		}
		for(int x=0;x<a.length;x++) {
			System.out.print(a[x]);
			System.out.println('\t');
		}
		

	}

}
