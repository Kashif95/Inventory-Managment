/**
 * 
 */
package com.sellar.managment.fms.report;

/**
 * @author rakumari
 *
 */
public enum ReportColumNameEnum {
	
	Column1("ORDER ID"),
	Column2("PRODUCT ID"),
	Column3("PRODUCT NAME"),
	Column4("AGENCY ID"),
	Column5("AGENCY NAME"),
	Column6("QUANTITY"),
	Column7("ORDER TOTAL PRICE"),
	Column8("ORDER PRICE"),
	Column9("LABOUR CHARGE"),
	Column10("SHIPPING CHARGE"),
	Column11("RETAILER NAME"),
	Column12("RETAILER CONTACT NUMBER"),
	Column13("ORDER DATE"),
	Column14("ORDER STATUS"),
	Column15("PAYMENT MODE");
	
	
    String name;
	
	
	private ReportColumNameEnum(String name){
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	

}
