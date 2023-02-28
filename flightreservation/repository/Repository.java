package console.flightreservation.repository;

import console.flightreservation.dto.Bookings;
import console.flightreservation.dto.Flight;
import console.flightreservation.dto.Passenger;
import console.flightreservation.dto.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Repository {
    private static Repository data;
    private Connection conn;
    private static final String url = "jdbc:mysql://localhost:3306/flight_reservation";
    String username = "root";
    String password = "root";

    private Repository() {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Error in server connection");
        }

    }

    public static Repository getInstance() {
        if (data == null) {
            data = new Repository();
        }
        return data;
    }

    public User checkUserLogin(String name, String password) {
        User user = null;
        String query = "SELECT name,password,admin FROM User WHERE name=? ";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            rs.next();
            if (!rs.getBoolean(3)) {
                if (rs.getString(2).equals(password)) {
                    user = new User(rs.getString(1), rs.getString(2), rs.getBoolean(3));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    public User checkAdminLogin(String userName, String password) {
        User user = null;
        String query = "SELECT name,password,admin FROM User WHERE name=? ";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, userName);
            ResultSet rs = statement.executeQuery();
            rs.next();
            if (rs.getBoolean(3)) {
                if(rs.getString(2).equals(password)) {
                    user = new User(rs.getString(1), rs.getString(2), rs.getBoolean(3));
                }
            }
        } catch (SQLException e) {
            System.out.println("exception in check admin login");
        }
        return user;
    }

    public List<Flight> checkFlight(String from, String to, String date) {
        List<Flight> flights = new ArrayList<>();
        String query = "SELECT * FROM flight where fromLocation=? AND toLocation=? AND date=?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, from);
            statement.setString(2, to);
            statement.setString(3, date);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                flights.add(new Flight(rs));
            }
        } catch (SQLException e) {
            System.out.println("error in checkflight");
        }
        return flights;
    }


    public boolean addBooking(Flight flight, List<Passenger> passengerList, User user) {
        String query = "INSERT INTO Bookings(userName,flightId,totalAmount) VALUES (?,?,?)";
        try {
            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getName());
            statement.setInt(2, flight.getId());
            statement.setInt(3, passengerList.size() * flight.getTicketPrice());
            statement.execute();
            String query2="UPDATE flight SET available_seats = ? WHERE id = ?";
            PreparedStatement statement2=conn.prepareStatement(query2);
            statement2.setInt(1,flight.getAvailableseats()-passengerList.size());
            statement2.setInt(2,flight.getId());
            statement2.executeUpdate();
            ResultSet rs=statement.getGeneratedKeys();
            rs.next();
            for (Passenger passenger : passengerList) {
                String query1 = "INSERT INTO passenger(name,age,bookingId) VALUES (?,?,?)";
                PreparedStatement statement1 = conn.prepareStatement(query1);
                statement1.setString(1, passenger.getName());
                statement1.setInt(2, passenger.getAge());
                statement1.setInt(3, rs.getInt(1));
                statement1.executeUpdate();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Bookings> findBookings(User user) {
        List<Bookings> bookings = new ArrayList<>();
        String query = "SELECT * FROM Bookings WHERE userName=? ";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, user.getName());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String query1 = "SELECT * FROM flight WHERE id =? ";
                PreparedStatement statement1 = conn.prepareStatement(query1);
                statement1.setString(1, rs.getString(3));
                ResultSet rs1 = statement1.executeQuery();
                rs1.next();
                Flight flight = new Flight(rs1);
                String query2 = "SELECT * FROM passenger WHERE bookingId= ? ";
                PreparedStatement statement2 = conn.prepareStatement(query2);
                statement2.setInt(1, rs.getInt(1));
                ResultSet rs2 = statement2.executeQuery();
                List<Passenger> passengerList = new ArrayList<>();
                while (rs2.next()) {
                    passengerList.add(new Passenger(rs2.getString(2), rs2.getInt(3)));
                }
                bookings.add(new Bookings(rs.getInt(1), rs.getString(2), flight, passengerList, rs.getInt(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error in findbookings");
        }
        return bookings;
    }

    public Bookings checkBooking(int bookingId, User user) {
        Bookings booking = null;
        String query = "SELECT * FROM Bookings WHERE bookingId=?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, bookingId);
            ResultSet rs = statement.executeQuery();
            rs.next();
            if (rs.getString(2).equals(user.getName())) {
                String query1 = "SELECT * FROM flight WHERE id =? ";
                PreparedStatement statement1 = conn.prepareStatement(query1);
                statement1.setInt(1, rs.getInt(3));
                ResultSet rs1 = statement1.executeQuery();
                Flight flight = new Flight(rs1.getString(2), rs1.getInt(1), rs1.getString(3), rs1.getString(4), rs1.getString(5), rs1.getString(6), rs1.getString(7), rs1.getInt(8), rs1.getInt(9), rs1.getInt(10));
                String query2 = "SELECT * FROM passenger where bookingId=?";
                PreparedStatement statement2 = conn.prepareStatement(query2);
                statement2.setInt(1, rs.getInt(1));
                ResultSet rs2 = statement2.executeQuery();
                List<Passenger> passengerList = new ArrayList<>();
                while (rs2.next()) {
                    passengerList.add(new Passenger(rs2.getString(2), rs2.getInt(3)));
                }
                booking = new Bookings(rs.getInt(1), rs.getString(2), flight, passengerList, rs.getInt(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return booking;
    }

    public boolean deleteBooking(Bookings booking) {
        String query = "DELETE FROM TABLE Bookings WHERE id=?";
        //remove from passengers too
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, booking.getBookingId());
            return statement.execute();
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean addFlights(Flight flight) {
        String query = "INSERT INTO flight (name,fromLocation,toLocation,date,departure,droptime,capacity,available_seats,ticketPrice) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, flight.getName());
            statement.setString(2, flight.getFrom());
            statement.setString(3, flight.getTo());
            statement.setString(4, flight.getDate());
            statement.setString(5, flight.getDeparture());
            statement.setString(6, flight.getDropTime());
            statement.setInt(7, flight.getCapacity());
            statement.setInt(8, flight.getAvailableseats());
            statement.setInt(9, flight.getTicketPrice());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Flight checkFlight(int flightId, String date, String departure) {
        Flight flight=null;
        String query = "SELECT * FROM flight WHERE id=? AND date=? AND departure=?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1,flightId);
            statement.setString(2,date);
            statement.setString(3,departure);
            ResultSet rs=statement.executeQuery();
            if(rs.next()){
                flight=new Flight(rs);
            }
        } catch (SQLException e) {
            System.out.println("error in checkflight");
        }
        return flight;
    }

    public boolean deleteFlight(Flight flight) {
       try{
           String query1="SELECT * FROM Bookings WHERE flightId=?";
           PreparedStatement statement1=conn.prepareStatement(query1);
           statement1.setInt(1,flight.getId());
           ResultSet rs1=statement1.executeQuery();
           while (rs1.next()){
               String query2="DELETE FROM Passenger WHERE bookingId=?";
               PreparedStatement statement2=conn.prepareStatement(query2);
               statement2.setInt(1,rs1.getInt(1));
               statement2.execute();
           }
           String query3="DELETE FROM Bookings WHERE flightId=?";
           PreparedStatement statement3=conn.prepareStatement(query3);
           statement3.setInt(1,flight.getId());
           statement3.execute();
           String query="DELETE FROM flight WHERE id=?";
           PreparedStatement statement= conn.prepareStatement(query);
           statement.setInt(1,flight.getId());
           statement.execute();
           return true;
       }catch(SQLException e){
           e.printStackTrace();
        }
       return false;
    }

    public List<Flight> getFlights() {
        List<Flight> flights=new ArrayList<>();
        String query="SELECT * FROM flight";
        try{
            PreparedStatement statement=conn.prepareStatement(query);
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                flights.add(new Flight(rs));
            }
        }catch (SQLException e){
            System.out.println("Error in getFlight");
        }
        return flights;
    }

    public boolean createuser(String name, String password, boolean admin) {
        String query = "INSERT INTO USER (name,password,admin) VALUES (? ,?,?)";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, password);
            statement.setBoolean(3, admin);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public void uploadFiles() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("error while closing");
        }
    }
}