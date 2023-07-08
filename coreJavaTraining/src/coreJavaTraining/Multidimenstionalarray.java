package coreJavaTraining;

public class Multidimenstionalarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int b[][]= {{3,1,5},{11,2,10},{14,4,0}};
		int c = b.length;
		//System.out.println(c);
		int lar = 5;
		int a = 0;
		int p=0;
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(lar>b[i][j]) {
					lar = b[i][j];
					a = i;
					p=j;
					
				}
				//System.out.print(b[i][j]);
				//System.out.print('\t');
			}
			//System.out.println("");
		}
			System.out.println(lar+" "+a+" "+p);
			
		int temp = 0;
		for(int x=0;x<3;x++) {
			for(int y=p;y<=p;y++) {
				if(lar<b[x][y])
					temp = b[x][y];
					lar = b[x][y];
			}
		}
		System.out.println(temp);
	}

}
