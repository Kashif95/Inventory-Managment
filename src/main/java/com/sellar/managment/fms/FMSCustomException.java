/**
 * 
 */
package com.sellar.managment.fms;

/**
 * @author rakumari
 *
 */
public class FMSCustomException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
	
	public FMSCustomException(String message){
		
		this.message = message;
	}

}
