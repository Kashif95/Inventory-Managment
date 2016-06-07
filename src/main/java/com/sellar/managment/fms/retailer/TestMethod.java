package com.sellar.managment.fms.retailer;

import java.util.Date;
import java.util.Random;

public class TestMethod {

	/**
	 * @param args
	 */
	public static int gen() {
	    Random r = new Random();
	    return 1 + r.nextInt(10000000);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( (int) (System.currentTimeMillis() & 0xfffffff));

	}

}
