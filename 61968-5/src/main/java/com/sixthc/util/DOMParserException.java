package com.sixthc.util;

import javax.xml.ws.WebFault;

@WebFault(name = "DOMParserException")  
public class DOMParserException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DOMParserException(String s)  {
		super(s);
	}
	
	public DOMParserException(String s, Exception e) {
		super(s, e);
	}	
}
