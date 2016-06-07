/**
 * 
 */
package com.sellar.managment.medicine;

/**
 * @author rakumari
 *
 */
public class MedicineCustomException extends RuntimeException{
	
	String message;
	
	public MedicineCustomException(String message){
		
		this.message = message;
	}

}
