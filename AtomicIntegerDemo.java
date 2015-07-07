package thread_learn;
import java.util.concurrent.atomic.*;



public class AtomicIntegerDemo {
	static int n=0;
	static AtomicInteger cnt = new AtomicInteger(0);
	public static void main(String[] args){
		final int NUM=4000;
		Thread[] threads=new Thread[NUM];
		for(int i=0;i<NUM;i++){
			threads[i]=new Thread(){
				public void run(){
					n++;
					cnt.getAndIncrement();
				}
			};
		}
		for(int i=0;i<NUM;i++)
			threads[i].start();
		try{
			Thread.sleep(3000);
		}catch(InterruptedException ex){}
		
		System.out.println(n);
		System.out.println(cnt.get()+" "+(cnt.get()==NUM));
		
	}
		
	
}
