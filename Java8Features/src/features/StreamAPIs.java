package features;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPIs {
	
	//Aggregate Operations - filter,map, limit, reduce, find , match
	//intermediate operations
	//terminal operation
	
	public static void main(String[] args) {
		
		//Get Sum of Integers in Array 
		//Before Java8 we had to accomplish same thing with external iteration
		int[] intgerArryay = {1,2,3,4,5,6,7};//Array
		int totalSum = Arrays.stream(intgerArryay).sum();
		System.out.println(totalSum);
		
		
		//Converting Stream into List and Map
		Stream<String> stream = Stream.of("Hello","World","This","Is","Java","8","Java","Is","Awesome");
		Stream<String> streamMap = Stream.of("Hello","World","This","Is","Java","8");
		System.out.println(stream.collect(Collectors.toList()));
		System.out.println(streamMap.collect(Collectors.toMap(i-> i, i -> i+10)));
		
		
		//Print 50 random numbers between 50-250  
		Random random = new Random();
		IntStream streamofrandomNumbers = random.ints(50,250);
		streamofrandomNumbers.limit(50).forEach(System.out::println);
		
		
	}

}
