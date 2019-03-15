package com.practice.calculator;

public class CalculatorImpl implements ICalculator {

	@Override
	public double tambah(double a, double b) {
		return a+b;
	}

	@Override
	public double kurang(double a, double b) {
		return a-b;
	}

	@Override
	public double kali(double a, double b) {
		return a*b;
	}

	@Override
	public double bagi(double a, double b) {
		return a/b;
	}

}
