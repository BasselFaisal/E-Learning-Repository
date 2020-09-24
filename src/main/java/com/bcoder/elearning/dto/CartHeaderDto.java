package com.bcoder.elearning.dto;

public class CartHeaderDto {
	
	int numerOfTutorials;
	
	double TotalPriceOfTutorials;

	public CartHeaderDto() {
	}

	public CartHeaderDto(int numerOfTutorials, double totalPriceOfTutorials) {
		this.numerOfTutorials = numerOfTutorials;
		TotalPriceOfTutorials = totalPriceOfTutorials;
	}

	public int getNumerOfTutorials() {
		return numerOfTutorials;
	}

	public double getTotalPriceOfTutorials() {
		return TotalPriceOfTutorials;
	}

	public void setNumerOfTutorials(int numerOfTutorials) {
		this.numerOfTutorials = numerOfTutorials;
	}

	public void setTotalPriceOfTutorials(double totalPriceOfTutorials) {
		TotalPriceOfTutorials = totalPriceOfTutorials;
	}

}
