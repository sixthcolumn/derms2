package com.sixthc.util;

import javax.xml.ws.WebFault;

@WebFault(name = "ImageLoadFileException")  
public class ImageLoadFileException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ImageLoadFileException(String s)  {
		super(s);
	}
	
	public ImageLoadFileException(String s, Exception e) {
		super(s, e);
	}	
}
