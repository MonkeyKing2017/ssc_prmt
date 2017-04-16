package com.test.main;

import java.math.BigDecimal;

public class TestMain {
	public static void main(String[] args) {
		BigDecimal price = new BigDecimal(new Integer(10));
		BigDecimal beisu = new BigDecimal(new Integer(11));
		System.out.println(price.multiply(beisu));
	}
}
