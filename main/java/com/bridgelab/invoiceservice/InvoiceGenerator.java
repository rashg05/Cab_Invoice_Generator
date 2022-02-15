package com.bridgelab.invoiceservice;

import java.util.HashMap;
import java.util.Map;
public class InvoiceGenerator {
	private static final int MIN_FARE = 5;


	public static double calculateFare(double distance, double time ,double distPrice,double timePrice) {
		double totalFare =  distance * distPrice + time * timePrice ;
		return Math.max(totalFare, MIN_FARE);
	}

	public static InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		for(Ride ride:rides) {
			totalFare += InvoiceGenerator.calculateFare(ride.distance, ride.time ,ride.distancePrice,ride.timePrice);
			System.out.println("dist "+ride.distance+"time"+ride.time);
		}
		System.out.println("inarray: "+new InvoiceSummary(rides.length, totalFare, totalFare / rides.length));
		return new InvoiceSummary(rides.length, totalFare, totalFare / rides.length);
		
	}

	public static InvoiceSummary calculateFare(int i, HashMap<Integer, Ride[]> rideRepo) {


		for (Map.Entry<Integer, Ride[]> rideEntry : rideRepo.entrySet()) {
			if (rideEntry.getKey() == i) {
				System.out.println("key"+rideEntry.getKey());
				System.out.println("inhash: "+calculateFare(rideEntry.getValue()));
				return calculateFare(rideEntry.getValue());
			
			}
		}

		return null;
	}

}