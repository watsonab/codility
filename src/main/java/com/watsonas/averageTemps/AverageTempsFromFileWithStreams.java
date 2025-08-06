package com.watsonas.averageTemps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.TreeMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Search file and average temps for each location
 */
public class AverageTempsFromFileWithStreams {
	public static Map<String,String> processFile( String fileName ) {
		// open file, try with resources
		try (Stream<String> lines = Files.lines( Path.of( fileName ))) { // "src/main/resources/measurements.txt"))) {

			// read lines with parallel collectors, group into a map by the first character
			// br.lines().parallel().collect( Collectors.groupingBy( line -> line.charAt(0) ));
			
			var allStats = lines.parallel().collect(
					   // group by the town name
					Collectors.groupingBy( line -> line.substring(0, line.indexOf(';')),
						// summarizingDouble eg DoubleSummaryStatistics{count=1, sum=-12.600000, min=-12.600000, average=-12.600000, max=-12.600000}
					Collectors.summarizingDouble(line -> 
						// double value of temperature
						Double.parseDouble(line.substring(line.indexOf(';') + 1)))));


			TreeMap<String,String> result = allStats.entrySet().stream().collect(
					// key is town name, value is DoubleSummaryStatistics
					Collectors.toMap(
							// key mapper
							Entry::getKey,
							// value mapper
							e -> {	var stats = e.getValue();
									return String.format("%.1f/%.1f/%.1f", stats.getMin(), stats.getAverage(), stats.getMax());	},		
							// merge function	
					 		(l, r) -> r, 
							// map factory
					 		TreeMap::new));
			
			System.out.println(result);
			return result;
		}
		catch( IOException e ) {
			System.err.println(e);
			return null;
		}
	}
}
