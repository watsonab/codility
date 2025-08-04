package com.watsonas.java23;

import java.math.BigDecimal;
import java.sql.DriverManager;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test; 

public class Java23Test {
	
	static public class BaseClass {
		int sum;
		
		private BaseClass( ) {
			System.out.println("Base class constructor");
			sum = 10;
		}
	}
	

	static public class ChildClass extends BaseClass {
		int data;
		
		private ChildClass( int data ) {
			super();
			this.data = data;
			System.out.println("Child class constructor");
		}
		
		public static ChildClass of( int data ) {
			return new ChildClass( data );
		}
	}
	
	@Test
	public void printInheritance() {
		ChildClass.of( 7 );
	}

	@Test
	public void nullableTest() {
		System.out.println( "Optional 1 " + Optional.of(BigDecimal.ZERO) );
		System.out.println( "Optional 2 " + Optional.ofNullable(null) ); 
	}

	
	@Test
	public void printClassLoaders() {
		System.out.println("Platform Classloader:" 
    	      + ClassLoader.getPlatformClassLoader()); 

    	    System.out.println("System Classloader:" 
    	      + ClassLoader.getSystemClassLoader());

    	    System.out.println("Classloader of this class:"
    	      + Java23Test.class.getClassLoader());

    	    System.out.println("Classloader of DriverManager:"
    	      + DriverManager.class.getClassLoader());

    	    System.out.println("Classloader of ArrayList:"
    	      + ArrayList.class.getClassLoader());
	}
	
	@Test
	public void switchTests() {
		for (int i = 0; i < 3; i++) {
			String answer = switch (i) {
				case 0 -> "zero";
				case 1 -> "one";
				case 2 -> "two";
				default -> "unlikely";
			};

			System.out.println(i + " is a " + answer );
		}
	}
	

	@Test
	public void streamTests() {
		List<String> fruits = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");
		// Using Stream API to filter and transform elements
		List<String> result = fruits.stream()
				.filter(fruit -> fruit.length() > 5)
				.map(String::toUpperCase)
				.collect(Collectors.toList());
		
		System.out.println(result);
    	
    	String[] words = {"apple", "banana", "cherry", "date", "elderberry"};
    	  
        // Using explicit lambda expression for sorting
        Arrays.sort(words, (a, b) -> a.compareToIgnoreCase(b));
        // Using method reference to sort the array
        Arrays.sort(words, String::compareToIgnoreCase);
        
        System.out.println(Arrays.asList(words));
	}
	
	@Test
	public void recordTests() {
		// bit like Lombok immutable data?
		record Point(int x, int y) {}
		Point obj = new Point( 4,5 );
		
		int result = -1;
	    if(obj instanceof Point(int x, int y)) {
	        result = x+y;
	    }
	    System.out.println( obj + " total is " + result + ",x is " + obj.x() + ",y is " + obj.y());
	}

	
	@Test
	public void virtualThreadTests() {
		System.out.println("10 virtual threads");
		long start = System.currentTimeMillis();

		try(var executor = Executors.newVirtualThreadPerTaskExecutor()) {
		    IntStream.rangeClosed(1, 10).forEach(i -> {
		        executor.submit(() -> {
		            System.out.println(i);
		            try {
		                Thread.sleep(Duration.ofSeconds(1));
		            } 
		            catch (InterruptedException e) {
		                e.printStackTrace();
		            }
		        });
		    });
		}
	
		System.out.println( "Completed in " + ( System.currentTimeMillis() - start ) + " ms");
		System.out.println("10 tasks via cached thread pool");
		start = System.currentTimeMillis();

		try(ExecutorService executor = Executors.newCachedThreadPool()) {
			for ( int i = 0; i < 10; i++ ) {
		    // IntStream.rangeClosed(1, 10_000).forEach(i -> {
				final int number = i;
		        executor.submit(() -> {
		            System.out.println(number);
		            try {
		                Thread.sleep(Duration.ofSeconds(1));
		            } 
		            catch (InterruptedException e) {
		                e.printStackTrace();
		            }
		        });
		    };
		}

		System.out.println( "Completed in " + ( System.currentTimeMillis() - start ) + " ms");

	}

	
}
