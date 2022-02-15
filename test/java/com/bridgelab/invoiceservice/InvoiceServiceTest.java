package com.bridgelab.invoiceservice;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.HashMap;

public class InvoiceServiceTest {
	InvoiceGenerator i = null;
	RideRepository rideRepository = new RideRepository();
	HashMap<Integer, Ride[]> rideRepo;
	@Before
	public void initialization() {
		i = new InvoiceGenerator();
		rideRepo = rideRepository.getRideRepo();
	}
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		double distance = 2.0;
		int time = 5;
		double fare = InvoiceGenerator.calculateFare( distance, time,10,1);
		Assert.assertEquals(25, fare, 0.0);
	}

	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinFare() {
		double distance = 0.1;
		int time = 1;
		double fare = InvoiceGenerator.calculateFare( distance, time,10,1);
		Assert.assertEquals(5, fare ,  0.0);
	}

	@Test
	public void givenMultipleRide_ShouldReturnToatalFare() {
         Ride[] rides = { new Ride(2.0, 5,"",0),
        		          new Ride(0.1, 1,"",0),
                         };
         InvoiceSummary summary = InvoiceGenerator.calculateFare(rides);
         InvoiceSummary expectedInvoiceSummary =  new InvoiceSummary(2, 30.0,15.0);
         Assert.assertEquals(expectedInvoiceSummary, summary);
	}
	 
	@Test
	public void givenUserId_ShouldReturnListOfRides() {
		Ride[] rides1 = { new Ride(0.1, 2.0,"premium",1), new Ride(10.0, 3.0, "normal",2) };
		Ride[] rides2 = { new Ride(3.0, 2, "normal",2), new Ride(1, 3, "premium",1), new Ride(150, 300, "premium",1) };
		Ride[] rides3 = { new Ride(5, 7, "normal",2) };

		rideRepo.put(1, rides1);
		rideRepo.put(2, rides2);
		rideRepo.put(3, rides3);

		InvoiceSummary invoice = new InvoiceSummary(3, 2903, 967.6666666666666);

		Assert.assertEquals(invoice, InvoiceGenerator.calculateFare(2, rideRepo));
	}
}