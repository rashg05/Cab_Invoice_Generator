package com.bridgelab.invoiceservice;

public class Ride {
	public double distance;
	public double time;
	public String category;
	
	public double distancePrice;
	public double timePrice;
	
	public Ride(double distance, double time, String category,int ch) {
		super();
		this.distance = distance;
		this.time = time;
		
		switch (ch) {
		case 1: 
			this.distancePrice = 15;
			this.timePrice = 2;
			break;
		case 2:
			this.distancePrice = 10;
			this.timePrice = 1;
			break;
		default:
			this.distancePrice = 10;
			this.timePrice = 1;			
		}
	}
}