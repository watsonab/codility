package com.watsonas.names;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MapFromNameFile implements MapFromName {

	private final String fileName;
	
	public MapFromNameFile( String fileName ) {
		this.fileName = fileName;
	}
	
	@Override
	public Map<String, NameAndEmail> createMap() {

		Map<String,NameAndEmail> result = new HashMap<String, NameAndEmail>(); 

		try ( BufferedReader br = new BufferedReader( new FileReader( fileName ) ) ) {

			while( br.ready() ) {
				Optional<NameAndEmail> val = NameAndEmail.fromLine(br.readLine());
				if ( val.isPresent() ) {
					result.put( val.get().email(), val.get() );
				}
			}

		}
		catch( IOException e ) {
			System.err.print( e );
		}

		
		return result;

	}

}
