package com.watsonas.names;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test; 

public class MapFromNameTest {
	
	@Test
	public void testMapFromName( ) {
		
		MapFromName processor = new MapFromNameFile( "src/test/resources/names.txt" );
		
		Map<String, NameAndEmail> result = processor.createMap();
		
		assertEquals( 3, result.size() );
	}

	@Test
	public void testMapFromNameWithStreams( ) {
		
		MapFromName processor = new MapFromNameFileWithStreams( "src/test/resources/names.txt" );
		
		Map<String, NameAndEmail> result = processor.createMap();
		
		assertEquals( 3, result.size() );
	}

}
