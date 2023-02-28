package console.flightreservation.user.cancelbooking;

import console.flightreservation.user.booking.Bookingview;
import console.flightreservation.dto.Bookings;
import console.flightreservation.dto.User;

import java.util.Scanner;

public class CancelView implements CancelviewControllerCallback {
    private CancelControllerViewCallback cancelController;
    private Scanner sc=new Scanner(System.in);
    private User user;
    public CancelView(){
        this.cancelController=new CancelController(this);
    }
    private void start(){
        System.out.printf("%50S","<-- Cancel booking page -->\n");
        System.out.println("Enter the Booking id");
        int bookingId=sc.nextInt();
        sc.nextLine();
        cancelController.checkBooking(bookingId,user);
    }

    public void init(User user){
        this.user=user;
        start();
    }

    @Override
    public void bookingFound(Bookings booking) {
        System.out.println("Booking "+ booking.getBookingId()+" found");
        System.out.println("Enter CONFIRM (in full caps) to delete or any other key to exit");
        String choice=sc.nextLine();
        if(choice.equals("CONFIRM")){
            cancelController.delete(booking);
        }else{
            exitCancellation();
        }
    }

    @Override
    public void bookingNotFound(int bookingId) {
        System.out.println("The booking Id "+ bookingId+" is not found.");
        start();
        /// redirect
    }

    @Override
    public void exitCancellation() {
        System.out.println("EXITTING CANCELLATION");
        start();
        //redirect to booking page 3 points
    }

    @Override
    public void cancellationSuccess(int bookingId) {
        System.out.println("Cancellation Successfull");
        Bookingview bv=new Bookingview();
        bv.init(user);
    }

    @Override
    public void cancellationFailed() {
        System.out.println("Cancellation process failed");
        //redirect to booking page 3 points
        start();
    }
}
