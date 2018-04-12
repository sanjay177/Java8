package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class MultipleThread {

	public static void main(String[] args) throws InterruptedException {
		MultipleThread singleObj = new MultipleThread();
		ExecutorService executor = Executors.newFixedThreadPool(2); // only 2 threads will remain active , if tasks are  greater than 2 it will wait for threads to be available
		//Runnable Task
		Runnable task1 = () -> {
			IntStream.range(1, 10).mapToObj(i -> singleObj.makeMeSleep(i)).forEach(System.out::println);;
			};
			
		Runnable task2 = () -> {
				IntStream.range(1, 10).mapToObj(i -> singleObj.makeMeSleep(i)).forEach(System.out::println);;
				};
				
		Runnable task3 = () -> {
				IntStream.range(1, 10).mapToObj(i -> singleObj.makeMeSleep(i)).forEach(System.out::println);;
					};
		executor.execute(task1);
		executor.execute(task2);
		executor.execute(task3);
		executor.shutdown();
		
		//Thread Pool Executor 
		ThreadPoolExecutor tpe = (ThreadPoolExecutor) Executors.newCachedThreadPool();// Create thread with default configuration
		tpe.submit(() -> {
		    Thread.sleep(10000);
		    System.out.println("Sleeping for 1 Second for Number Thread Name "+Thread.currentThread().getName());
		    return null;
		});
		tpe.submit(() -> {
		    Thread.sleep(20000);
		    System.out.println("Sleeping for 1 Second for Number Thread Name "+Thread.currentThread().getName());
		    return null;
		});
		tpe.submit(() -> {
		    Thread.sleep(30000);
		    System.out.println("Sleeping for 1 Second for Number Thread Name "+Thread.currentThread().getName());
		    return null;
		});
		
		tpe.shutdown();
		
		System.out.println("Exiting Main");
		
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
