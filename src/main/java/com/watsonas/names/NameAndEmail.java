package com.watsonas.names;

import java.util.Optional;

public record NameAndEmail( String name, String email ) {
	private final static String regex = ",";

	public static Optional<NameAndEmail> fromLine( String line ) {
	 String[] parts = line.split(regex);
	
	 if ( parts.length == 2 ) {
		String name = parts[0];
		String email = parts[1];
		return Optional.of(new NameAndEmail( name, email ) );
	}
	 return Optional.empty();
	}
} 
	

