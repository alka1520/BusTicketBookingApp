package com.model;

public class BusDetails {
	
	private int BusId;
	private String BusName;
	private String BusType;
	private int RouteId;
	private int BusSeats;
	private String ArrivalTime;
	private String DepartureTime;
	
	@Override
	public String toString() {
		return "BusDetails [BusId=" + BusId + ", BusName=" + BusName + ", BusType=" + BusType + ", RouteId=" + RouteId
				+ ", BusSeats=" + BusSeats + ", ArrivalTime=" + ArrivalTime + ", DepartureTime=" + DepartureTime + "]";
	}

	public int getBusId() {
		return BusId;
	}

	public void setBusId(int busId) {
		BusId = busId;
	}

	public String getBusName() {
		return BusName;
	}

	public void setBusName(String busName) {
		BusName = busName;
	}

	public String getBusType() {
		return BusType;
	}

	public void setBusType(String busType) {
		BusType = busType;
	}

	public int getRouteId() {
		return RouteId;
	}

	public void setRouteId(int routeId) {
		RouteId = routeId;
	}

	public int getBusSeats() {
		return BusSeats;
	}

	public void setBusSeats(int busSeats) {
		BusSeats = busSeats;
	}

	public String getArrivalTime() {
		return ArrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		ArrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return DepartureTime;
	}

	public void setDepartureTime(String departureTime) {
		DepartureTime = departureTime;
	}

	public BusDetails(int busId, String busName, String busType, int busSeats, String arrivalTime,
			String departureTime) {
		super();
		BusId = busId;
		BusName = busName;
		BusType = busType;
		BusSeats = busSeats;
		ArrivalTime = arrivalTime;
		DepartureTime = departureTime;
	}
	
	
}