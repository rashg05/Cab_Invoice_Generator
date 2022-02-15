package com.bridgelab.invoiceservice;

public class InvoiceSummary {
	int noOfRides;
	double totalFare;
	double avarageFare;
	public InvoiceSummary(int noOfRides, double totalFare , double avarageFare ) {
		this.noOfRides = noOfRides;
		this.totalFare = totalFare;
		this.avarageFare = avarageFare;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null ||  getClass() != o.getClass()) return false;
		InvoiceSummary that = (InvoiceSummary) o ;
		return noOfRides == that.noOfRides &&
				Double.compare( that.totalFare, totalFare) == 0 &&
				Double.compare (that.avarageFare, avarageFare) == 0;
	}
	@Override
	public String toString() {
		return "Invoice [rideCount=" + noOfRides + ", totalFare=" + totalFare + ", avgFare=" + avarageFare + "]";
	}

}