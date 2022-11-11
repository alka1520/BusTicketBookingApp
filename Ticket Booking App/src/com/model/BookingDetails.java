package com.model;

public class BookingDetails {

	
	private int BookingId;
	private int TicketId;
	private String Name;
	private String BusName;
	private String BusType;
	private String ArrivalTime;
	private String DepartureTime;
	private String TravelDate;
	private String From;
	private String To;
	private int SeatNO;
	public int getBookingId() {
		return BookingId;
	}
	public void setBookingId(int bookingId) {
		BookingId = bookingId;
	}
	public int getTicketId() {
		return TicketId;
	}
	public void setTicketId(int ticketId) {
		TicketId = ticketId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
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
	public String getTravelDate() {
		return TravelDate;
	}
	public void setTravelDate(String travelDate) {
		TravelDate = travelDate;
	}
	public String getFrom() {
		return From;
	}
	public void setFrom(String from) {
		From = from;
	}
	public String getTo() {
		return To;
	}
	public void setTo(String to) {
		To = to;
	}
	public int getSeatNO() {
		return SeatNO;
	}
	public void setSeatNO(int seatNO) {
		SeatNO = seatNO;
	}
	public BookingDetails(int bookingId, int ticketId, String name, String busName, String busType, String arrivalTime,
			String departureTime, String travelDate, String from, String to, int seatNO) {
		super();
		BookingId = bookingId;
		TicketId = ticketId;
		Name = name;
		BusName = busName;
		BusType = busType;
		ArrivalTime = arrivalTime;
		DepartureTime = departureTime;
		TravelDate = travelDate;
		From = from;
		To = to;
		SeatNO = seatNO;
	}
	@Override
	public String toString() {
		return "BookingId=" + BookingId + ", TicketId=" + TicketId + ", Name=" + Name + ", BusName="
				+ BusName + ", BusType=" + BusType + ", ArrivalTime=" + ArrivalTime + ", DepartureTime=" + DepartureTime
				+ ", TravelDate=" + TravelDate + ", From=" + From + ", To=" + To + ", SeatNO=" + SeatNO ;
	}
	
	
	
}
