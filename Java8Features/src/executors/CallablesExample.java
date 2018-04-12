package executors;

import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class CallablesExample {

	public static void main(String[] args) throws InterruptedException {
		CallablesExample singleObj = new CallablesExample();
		ExecutorService executor = Executors.newSingleThreadExecutor();//At a time only 1 thread will remain live
		
		//Comparator Interface Implementation on the run 
		Comparator<Integer> comparatorObj = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1==o2) {
					return 0;
				}
				else if (o1>o2) {
					
					return 1;
				}
				else  {
					return -1;
				}
			}
		};
		//ExecutorService executor = Executors.newFixedThreadPool(2);
		//Runnable Task
		Callable<Integer> callableTask = () ->Integer.valueOf(IntStream.range(1, 10).mapToObj(i -> singleObj.makeMeSleep(i)).min(comparatorObj).get());
		Future<Integer> future = executor.submit(callableTask);
		executor.shutdown();
		System.out.println("Exiting Main After 5 Second wait");
		
		System.out.println("future done? " + future.isDone());
		try {
			Integer result = future.get(); // Wait for execution to complete
			System.out.println("future done? " + future.isDone());
			System.out.print("result: " + result); // Print out the result 
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
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
