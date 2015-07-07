package thread_learn;



import java.util.concurrent.*;



class MyTask2 implements Runnable{
	int n=10;
	public MyTask2(int n){this.n=n;}
	public void run(){
		for(int i=0;i<n;i++){
			System.out.println(i);
		}
	}
	
}

class ThreadPoolDemo {
	public static void main(String[] args){
		ExecutorService pool = Executors.newCachedThreadPool();
		MyTask2 t1 = new MyTask2(5);
		MyTask2 t2 = new MyTask2(7);
		MyTask2 t3 = new MyTask2(8);
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		
	}
}

