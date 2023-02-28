package console.flightreservation.dto;

import java.util.List;

public class Bookings {
    private int bookingId;
    private String userName;
    private Flight flight;
    private List<Passenger> passengerList;
    private int totalAmount;

    public Bookings(){
    }
    public Bookings(int bookingId,String userName, Flight flight, List<Passenger> passengerList, int totalAmount) {
        this.bookingId = bookingId;
        this.userName = userName;
        this.flight = flight;
        this.passengerList = passengerList;
        this.totalAmount = totalAmount;
    }
    public int getTotalAmount(){
        return totalAmount;
    }
    public Flight getFlight() {
        return flight;
    }
    public List<Passenger> getPassengerList() {
        return passengerList;
    }
    public int getBookingId() {
        return bookingId;
    }
    public String print() {
        System.out.println("Bookings{" +
                "bookingId=" + bookingId +
                ", userName='" + userName + '\'' +
                ", totalAmount=" + totalAmount +
                '}');
        System.out.println(flight.toString());
        for(Passenger passenger:passengerList){
            System.out.println(passenger.toString());
        }
        return "\n";
    }
    public String getUserName() {
        return userName;
    }
}
