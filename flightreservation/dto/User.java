package console.flightreservation.dto;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String password;
    private List<Bookings> bookings;
    private boolean admin;

    public User(){
    }

    public boolean isAdmin() {
        return admin;
    }

    public User(String name, String password, boolean admin) {
        this.name = name;
        this.password = password;
        this.bookings = new ArrayList<>();
        this.admin =admin;
    }
    public void addBookings(Bookings bookings) {
        this.bookings.add(bookings);
    }

    public List<Bookings> getBookings() {
        return bookings;
    }

    public String getPassword(){
        return password;
    }

    public boolean checkAdmin() {
        return admin;
    }
    public String getName() {
        return name;
    }

}
