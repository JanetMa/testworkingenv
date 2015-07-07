package thread_learn;

public class myTask implements Runnable{
	public void run(){
		for(int i=0;i<100;i++){
			System.out.print(" "+i);
		}
	}
	public static void main(String args[]){
		Thread thread = new Thread(myTask);
		thread.start();
		
	}
	
}
