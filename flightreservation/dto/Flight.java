package console.flightreservation.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Flight {
    private String name;
    private int id;
    private String from;
    private String date;
    private String to;
    private String departure;
    private String dropTime;
    private int capacity;
    private int availableseats;
    private int ticketPrice;


    public Flight(){

    }

    public int getCapacity() {
        return capacity;
    }

    public String getDropTime() {
        return dropTime;
    }



    public Flight(String name, int id, String from, String to, String date, String departure, String dropTime, int capacity, int availableseats, int ticketPrice) {
        this.name = name;
        this.id = id;
        this.from = from;
        this.date = date;
        this.to = to;
        this.departure = departure;
        this.dropTime = dropTime;
        this.capacity = capacity;
        this.availableseats = availableseats;
        this.ticketPrice = ticketPrice;
    }
    public Flight(String name, String from, String to, String date, String departure, String dropTime, int capacity, int availableseats, int ticketPrice) {
        this.name = name;
        this.from = from;
        this.date = date;
        this.to = to;
        this.departure = departure;
        this.dropTime = dropTime;
        this.capacity = capacity;
        this.availableseats = availableseats;
        this.ticketPrice = ticketPrice;
    }

    public void alterAvailableSeats(int booked) {
        this.availableseats = availableseats-booked;
    }

    public String getFrom() {
        return from;
    }

    public String getDate() {
        return date;
    }

    public String getTo() {
        return to;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDeparture() {
        return departure;
    }

    public int getAvailableseats() {
        return availableseats;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public Flight(ResultSet rs) throws SQLException {
        this(rs.getString(2), rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
    }

    @Override
    public String toString() {
        return "Flight{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", from='" + from + '\'' +
                ", date='" + date + '\'' +
                ", to='" + to + '\'' +
                ", departure='" + departure + '\'' +
                ", dropTime='" + dropTime + '\'' +
                ", ticketPrice=" + ticketPrice +
                '}';
    }

    public String print() {
        return "Flight{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", from='" + from + '\'' +
                ", date='" + date + '\'' +
                ", to='" + to + '\'' +
                ", departure='" + departure + '\'' +
                ", dropTime='" + dropTime + '\'' +
                ", capacity=" + capacity +
                ", availableseats=" + availableseats +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
