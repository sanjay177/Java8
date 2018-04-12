package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SingleThreadExecutor {

	public static void main(String[] args) throws InterruptedException {
		SingleThreadExecutor singleObj = new SingleThreadExecutor();
		ExecutorService executor = Executors.newSingleThreadExecutor();//At a time only 1 thread will remain live
		//ExecutorService executor = Executors.newFixedThreadPool(2);
		//Runnable Task
		Runnable task1 = () -> {
			IntStream.range(1, 10).mapToObj(i -> singleObj.makeMeSleep(i)).forEach(System.out::println);;
			};
		executor.execute(task1);
		executor.awaitTermination(5, TimeUnit.SECONDS); //Put current thread on wait for 5 seconds 
		executor.shutdown();
		System.out.println("Exiting Main After 5 Second wait");
		
	}
	
	public int makeMeSleep(int i ) {
		System.out.println("Sleeping for 1 Second for Number "+i+" Thread Name "+Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

}
