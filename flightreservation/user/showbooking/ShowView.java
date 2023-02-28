package console.flightreservation.user.showbooking;

import console.flightreservation.user.booking.Bookingview;
import console.flightreservation.dto.Bookings;
import console.flightreservation.dto.User;

import java.util.List;
import java.util.Scanner;

public class ShowView implements ShowViewControllerCallback {
    private ShowControllerViewCallback showController;
    private User user;
    private Scanner sc=new Scanner(System.in);

    public ShowView(){
        this.showController=new ShowController(this);
    }

    private void start(){
        System.out.printf("%50S","<-- Bookings -->\n");
        showController.checkBookings(user);
    }

    public void init(User user){
        this.user=user;
        start();
    }



    @Override
    public void noBookingsFound() {
        System.out.println("\nNo Bookings Found\nRedirecting to Booking section\n");
        System.out.println("\n press any key to direct to user page");
        sc.nextLine();
        Bookingview bv=new Bookingview();
        bv.init(user);
        //redirect to bookingView start
    }

    @Override
    public void bookingsFound(List<Bookings> bookings) {
        System.out.println();
        for(Bookings books:bookings){
            System.out.println(books.print());
        }
        System.out.println("\n press any key to direct to user page");
        sc.nextLine();
        Bookingview bv=new Bookingview();
        bv.init(user);
    }
}
