package com.practice.calculator;

public class CalculatorMain {
	public static void main(String[] args) {
		ICalculator calService = new CalculatorImpl();
		Calculator cal = new Calculator();

		cal.setA(6);
		cal.setB(3);
		
		System.out.println(calService.tambah(cal.getA(), cal.getB()));		
		System.out.println(calService.kurang(cal.getA(), cal.getB()));
		System.out.println(calService.kali(cal.getA(), cal.getB()));
		System.out.println(calService.bagi(cal.getA(), cal.getB()));
	}

}
