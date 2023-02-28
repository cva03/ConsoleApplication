package console.flightreservation.admin.manageflights;

import console.flightreservation.dto.Flight;
import console.flightreservation.dto.User;
import console.flightreservation.login.LoginView;

import java.util.List;
import java.util.Scanner;

public class ManageFlightsView implements ManageFlightsViewControllerCallback {
    private Scanner sc=new Scanner(System.in);
    private ManageFlightsControllerViewCallback manageFlightsController;
    private User user;
    public ManageFlightsView(){
        this.manageFlightsController=new ManageFlightsController(this);
    }
    private void start(){
        System.out.printf("%50S","<-- Admin page admin: "+user.getName()+" -->\n");
        System.out.println("1.Add flights");
        System.out.println("2.Remove Flights");
        System.out.println("3.Show Flights");
        System.out.println("4.Add users");
        System.out.println("5.Add admin");
        System.out.println("6.Logout");
        System.out.println("Select one option");
        int choice=sc.nextInt();
        sc.nextLine();
        switch (choice){
            case 1:
                addFlight();
                break;
            case 2:
                removeFlight();
                break;
            case 3:
                manageFlightsController.showFlights();
                break;
            case 4:
                addUser();
                break;
            case 5:
                addAdmin();
            case 6:
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
    public void addFlight() {
        System.out.printf("%50S","<-- Add flights -->");
        System.out.println("\nEnter the flight details");
        System.out.println("\nEnter the flight name");
        String flightName=sc.nextLine();
        System.out.println("Enter the start location ");
        String from=sc.nextLine();
        System.out.println("Enter the destination ");
        String to=sc.nextLine();
        System.out.println("Enter the date (in 00/00/0000 format)");
        String date=sc.nextLine();
        System.out.println("Enter the start time (in 24:00 format)");
        String departure=sc.nextLine();
        System.out.println("Enter the end time (in 24:00 format)");
        String dropTime=sc.nextLine();
        System.out.println("Enter the capacity");
        int capacity=sc.nextInt();
        System.out.println("Enter the available seats");
        int availableSeats=sc.nextInt();
        System.out.println("Enter the ticket price ");
        int ticketprice=sc.nextInt();
        sc.nextLine();
        Flight flight=new Flight(flightName,from,to,date,departure,dropTime,capacity,availableSeats,ticketprice);
        manageFlightsController.addFlights(flight);
    }

    @Override
    public void removeFlight() {
        System.out.printf("%50S","<-- Remove flights -->");
        System.out.println("\nEnter the flight id");
        int flightId=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the date (in 00/00/0000 format)");
        String date=sc.nextLine();
        System.out.println("Enter the start time (in 24:00 format)");
        String departure=sc.nextLine();
        manageFlightsController.checkFlight(flightId,date,departure);

    }

    @Override
    public void actionFailed() {
        System.out.println("\ninvalid input\n");
        start();
    }

    @Override
    public void addSuccessfull() {
        System.out.println("\nFlight added successfully\n");
        start();
    }

    @Override
    public void addFailed() {
        System.out.println("\nFlight data insertion failed\n");
        start();
    }

    @Override
    public void flightFound(Flight flight) {
        System.out.println(flight.print());
        System.out.println("\nEnter CONFIRM (in full caps) to remove flight or any other key to exit\n");
        String choice=sc.nextLine();
        if(choice.equals("CONFIRM")){
            manageFlightsController.deleteFlight(flight);
        }
        exitDeletion();
    }

    @Override
    public void flightNotFound() {
        System.out.println("\nFlight not found\n");
        start();
    }

    @Override
    public void exitDeletion() {
        System.out.println("\nExiting removeflights\n");
        start();
    }

    @Override
    public void deletionSuccessfull() {
        System.out.println("\nFlight removed successfully\n");
        start();
    }

    @Override
    public void deletionUnuccessfull() {
        System.out.println("\nFLight deletion unsuccessfull\n");
        start();
    }

    @Override
    public void listAllFlights(List<Flight> flights) {
        System.out.printf("%-10s%-20s%-15s%-15s%-15s%-20s%-15s%-15s%-20s%-15s\n","Id","Name","From","To","Date","Departure time","Drop time","Capacity","Availableseats","Ticket price");
        for(Flight flight:flights){
            System.out.printf("%-10d%-20s%-15s%-15s%-15s%-20s%-15s%-15d%-20d%-15d\n",flight.getId(),flight.getName(),flight.getFrom(),flight.getTo(),flight.getDate(),flight.getDeparture(),flight.getDropTime(),flight.getCapacity(),flight.getAvailableseats(),flight.getTicketPrice());
        }
        System.out.println("\n press any key to direct to Admin page");
        sc.nextLine();
        start();
    }

    @Override
    public void noFlightsFound() {
        System.out.println("\nNo flights found\n");
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
    public void addUser() {
        System.out.println("Enter the username");
        String name=sc.nextLine();
        System.out.println("Enter the password");
        String password=sc.nextLine();
        boolean admin=false;
        manageFlightsController.createuser(name,password,admin);

    }

    @Override
    public void addAdmin() {
        System.out.println("Enter the adminname");
        String name=sc.nextLine();
        System.out.println("Enter the password");
        String password=sc.nextLine();
        boolean admin=true;
        manageFlightsController.createuser(name,password,admin);
    }

    @Override
    public void adminCreationSuccessfull() {
        System.out.println("AdminCreation Successfull");
        start();
    }

    @Override
    public void adminCreationFailed() {
        System.out.println("Admin already found");
        start();
    }

    @Override
    public void userCreationSuccessfull() {
        System.out.println("User Creation Successfull");
        start();
    }

    @Override
    public void userCreationFailed() {
        System.out.println("User already found");
        start();
    }
}
