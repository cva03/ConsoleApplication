package console.flightreservation.user.booking;


import console.flightreservation.user.cancelbooking.CancelView;
import console.flightreservation.dto.Flight;
import console.flightreservation.dto.Passenger;
import console.flightreservation.dto.User;
import console.flightreservation.login.LoginView;
import console.flightreservation.user.showbooking.ShowView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bookingview implements BookingviewControllerCallback {
    private User user;
    private BookingControllerViewCallback bookingController;
    private Scanner sc=new Scanner(System.in);
    public Bookingview(){
        this.bookingController=new BookingController(this);
    }

    private void start(){
        System.out.printf("%50S","<-- Welcome to Booking section User: "+user.getName()+" -->\n");
        System.out.println("1.New Bookings");
        System.out.println("2.Show all Bookings");
        System.out.println("3.Cancel Bookings");
        System.out.println("4.logout");
        System.out.println("Select any choice : ");
        int choice=sc.nextInt();
        sc.nextLine();
        switch (choice){
            case 1:
                checkflight();
                break;
            case 2:
                showBookings();
                break;
            case 3:
                removeBookings();
                break;
            case 4:
                logOut();
            default:
               actionFailed();
        }
    }

    public void init(User user){
        this.user=user;
        start();
    }


    @Override
    public void checkflight() {
        System.out.println("Enter the source Location");
        String from=sc.nextLine();
        System.out.println("Enter the destination");
        String to=sc.nextLine();
        System.out.println("Enter the date (in 00/00/0000 format)");
        String date=sc.nextLine();
        bookingController.checkflight(from,to,date);

    }

    @Override
    public void showBookings() {
        ShowView sv=new ShowView();
        sv.init(user);
    }

    @Override
    public void removeBookings() {
        CancelView cv=new CancelView();
        cv.init(user);
    }

    @Override
    public void actionFailed() {
        System.out.println("Invalid choice\n");
        start();
    }

    @Override
    public void flightNotFound() {
        System.out.println("No flights found for the given information\n");
        System.out.println("Re-directing to Booking section");
        start();
    }

    @Override
    public void flightfound(List<Flight> foundFlights) {
        System.out.println(foundFlights.size()+" flights found");
        System.out.printf("%-10s%-15s%-15s%-15s%-15s%-20s%-15s%-15s\n","Id","Name","From","To","Date","Departure time","Drop time","Ticket price");
        for(Flight flight:foundFlights){
            System.out.printf("%-10d%-15s%-15s%-15s%-15s%-20s%-15s%-15d\n",flight.getId(),flight.getName(),flight.getFrom(),flight.getTo(),flight.getDate(),flight.getDeparture(),flight.getDropTime(),flight.getTicketPrice());
        }
        System.out.println("\nEnter the flight id to select the flight");
        int selectedFlightId=sc.nextInt();
        sc.nextLine();
        for(Flight flight:foundFlights){
            if(selectedFlightId==flight.getId() && flight.getAvailableseats()>0) {
                showSeats(flight,foundFlights);
                return;
            }
        }
        wrongFlightId(foundFlights);
    }

    @Override
    public void seatCheckfailed(Flight flight, List<Flight> foundFlights) {
        System.out.printf("Enter valid number of seats (higher than 0 and lowe than %d)", flight.getAvailableseats());
        flightfound(foundFlights);
    }

    @Override
    public void seatCheckSuccess(int seats, Flight flight, List<Flight> foundFlights) {
        List<Passenger> passengerList=new ArrayList<>();
        for(int i=0;i<seats;i++){
            System.out.println("Enter passenger "+ (i+1) + "'s name :");
            String name=sc.nextLine();
            System.out.println("Enter "+name+"'s age");
            int age=sc.nextInt();
            sc.nextLine();
            Passenger passenger=new Passenger(name,age);
            passengerList.add(passenger);
        }
        bookingController.addBooking(flight,passengerList,user);
    }

    @Override
    public void bookingSuccessful(User user) {
        System.out.println("Your booking is successful");
        start();
    }

    @Override
    public void bookingUnSuccessfull(User user) {
        System.out.println("Booking failed!:\nRedirecting to Booking section");
        start();
    }

    @Override
    public void logOut() {
        System.out.println("Enter CONFIRM(in full caps) to logout");
        String choice=sc.nextLine();
        if(choice.equals("CONFIRM")){
            confirmLogout();
        }else{
            logOutTermination();
        }
    }

    @Override
    public void confirmLogout() {
        LoginView lv=new LoginView();
        lv.init();
    }

    @Override
    public void logOutTermination() {
        start();
    }

    @Override
    public void wrongFlightId(List<Flight> foundFlights) {
        System.out.println("You have chosen the wrong flight id");
        System.out.println("Select the correct id\n");
        flightfound(foundFlights);
    }

    @Override
    public void showSeats(Flight flight, List<Flight> foundFlights) {
        System.out.println(flight.getAvailableseats()+" seats available");
        System.out.println("Enter the number of seats you want to book");
        int seats=sc.nextInt();
        sc.nextLine();
        if(seats> flight.getAvailableseats() || seats<1){
            seatCheckfailed(flight,foundFlights);
        }else{
            seatCheckSuccess(seats,flight,foundFlights);
        }
    }
}
