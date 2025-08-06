package com.watsonas.java23;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.watsonas.names.NameAndEmail;

public class StreamsTest {

	@Test
	public void streamCreationTests() {
		List<String> fruits = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");
		// Using Stream API to filter and transform elements
		List<String> result = fruits.stream().filter(fruit -> fruit.length() > 5).map(String::toUpperCase)
				.collect(Collectors.toList());

		System.out.println(result);

		String[] words = { "apple", "banana", "cherry", "date", "elderberry" };

		// Using explicit lambda expression for sorting
		Arrays.sort(words, (a, b) -> a.compareToIgnoreCase(b));
		// Using method reference to sort the array
		Arrays.sort(words, String::compareToIgnoreCase);

		System.out.println(Arrays.asList(words));

		Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);

		List<Integer> ints = streamIterated.collect(Collectors.toList());

		System.out.println(ints.toString());

		IntStream intStream = IntStream.range(1, 4);
		// sum of stream
		System.out.println(intStream.reduce( ( a, b ) -> a + b ).getAsInt());

		Stream<String> streamOfString = Pattern.compile(", ").splitAsStream("a, b, c");
		
		String listToString = streamOfString.collect(Collectors.joining("--", "{", "}"));

		System.out.println(listToString);

	}

	@Test
	public void streamFileCreationTests() {
		Path path = Paths.get("src/test/resources/names.txt");
		try ( Stream<String> streamWithCharset = Files.lines(path, Charset.forName("UTF-8"))) {
			
			Stream<String> filtered = streamWithCharset.filter(element -> element.contains("Watson"));
			
			Stream<Optional<NameAndEmail>> mapped = filtered.map(element -> NameAndEmail.fromLine(element) );
			
			System.out.println(Arrays.toString(mapped.toArray()));
		}
		catch( IOException ioe ) {
			System.err.print(ioe);
		}

	}
}
