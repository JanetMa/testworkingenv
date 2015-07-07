package thread_learn;

public class Prime100Continue {
	public static void main(String[] args){
		System.out.println("100---200 primenumbers:");
		int n=0;
		outer:	for(int i=101;i<200;i+=2){
			for(int j=2;j<i;j++){
				if(i%j==0){
					continue outer; 
				}
			}
			System.out.print(" "+i);
			n++;
		}
		
		System.out.println(n);
	}
	

}
