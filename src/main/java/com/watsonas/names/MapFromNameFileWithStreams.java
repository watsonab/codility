package com.watsonas.names;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapFromNameFileWithStreams implements MapFromName {

	private final String fileName;
	
	public MapFromNameFileWithStreams( String fileName ) {
		this.fileName = fileName;
	}
	
	@Override
	public Map<String, NameAndEmail> createMap() {
		Map<String,NameAndEmail> result = new HashMap<>();

		try ( BufferedReader br = new BufferedReader( new FileReader( fileName ) ) ) {
		
			Stream<Optional<NameAndEmail>> intermediate = br.lines()
					.map(line ->  NameAndEmail.fromLine( line ));
			
			var map = intermediate.collect( 
					Collectors.groupingBy(nameAndEmail -> nameAndEmail.get().email() ) ) ;

			for( String key : map.keySet() ) {
				List<Optional<NameAndEmail>> value = map.get(key);
				if ( !value.isEmpty() ) {
					result.put( key, value.getFirst().get() );
				}
			}
		}
		catch( IOException e ) {
			System.err.print( e );
		}

		return result;

	}

}
