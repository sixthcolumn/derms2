package com.sixthc.util;

import javax.xml.ws.WebFault;

@WebFault(name = "DOMParserException")  
public class MSHeaderException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MSHeaderException(String s)  {
		super(s);
	}
	
	public MSHeaderException(String s, Exception e) {
		super(s, e);
	}	
}
