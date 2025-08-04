package com.watsonas.codility;

public class LinkedListAw<T> {

	private Element<T> head;
	private Element<T> tail;
	
	public LinkedListAw<T> push( T data ) {
		Element<T> newElement = new Element<T>(data, null);
		if ( head != null ) {
			head.previousElement = newElement;
		}
		head = newElement;
		if ( tail == null ) {
			tail = head;
		}
		return this;
	}
	
	public T pop( ) {
		Element<T> result = tail;
		if ( result != null ) {
			tail = result.previousElement;
			return result.thisData;
		}
		return null; // empty list
		
	}
	
	static class Element<T> {
		T thisData;
		Element<T> previousElement;

		public Element(T thisData, Element<T> nextElement) {
			this.thisData = thisData;
			this.previousElement = nextElement;
		}
		
		public String toString() {
			if ( previousElement != null ) {
				return thisData.toString() + " previous is " + previousElement.toString();
			}
			return thisData.toString() ;
		}

	}
	
	public boolean isEmpty() {
		return tail == null;
	}
}
