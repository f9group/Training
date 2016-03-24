package com.five9group.basics;

public class Renter {

	private Car car;
	
	public Renter(Car car){
		this.car= car;
	}

	public void displayCostOfHiringCar(){
		System.out.println("the cost of hiring " + car.getNameOfCar() + " is $" + car.getPerDayCost() );
	}
}
