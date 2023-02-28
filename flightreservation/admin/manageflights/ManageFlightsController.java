package console.flightreservation.admin.manageflights;

import console.flightreservation.dto.Flight;

import java.util.List;

public class ManageFlightsController implements ManageFlightsControllerModelCallback, ManageFlightsControllerViewCallback {
    private ManageFlightsViewControllerCallback manageFlightsView;
    private ManageFlightsModelControllerCallback manageFlightsModel;
    public ManageFlightsController(ManageFlightsView manageFlightsView) {
        this.manageFlightsView=manageFlightsView;
        this.manageFlightsModel=new ManageFlightsModel(this);
    }

    @Override
    public void checkFlight(int flightId, String date, String departure) {
        manageFlightsModel.checkFlight(flightId,date,departure);
    }


    @Override
    public void createuser(String name, String password, boolean admin) {
       manageFlightsModel.createuser(name,password,admin);
    }

    @Override
    public void addFlights(Flight flight) {
        manageFlightsModel.addFlights(flight);
    }

    @Override
    public void deleteFlight(Flight flight) {
        manageFlightsModel.deleteFlight(flight);
    }

    @Override
    public void showFlights() {
        manageFlightsModel.showFlights();
    }


    @Override
    public void addSuccessfull() {
        manageFlightsView.addSuccessfull();
    }

    @Override
    public void addFailed() {
        manageFlightsView.addFailed();

    }

    @Override
    public void flightFound(Flight flight) {
        manageFlightsView.flightFound(flight);
    }

    @Override
    public void flightNotFound() {
        manageFlightsView.flightNotFound();
    }

    @Override
    public void deletionSuccessfull() {
        manageFlightsView.deletionSuccessfull();
    }

    @Override
    public void deletionUnsuccessfull() {
        manageFlightsView.deletionUnuccessfull();
    }

    @Override
    public void listAllFlights(List<Flight> flights) {
        manageFlightsView.listAllFlights(flights);
    }

    @Override
    public void noFlightsFound() {
        manageFlightsView.noFlightsFound();
    }

    @Override
    public void adminCreationSuccessfull() {
        manageFlightsView.adminCreationSuccessfull();
    }

    @Override
    public void userCreationSuccessfull() {
        manageFlightsView.adminCreationSuccessfull();
    }

    @Override
    public void adminCreationFailed() {
        manageFlightsView.adminCreationFailed();
    }

    @Override
    public void userCreationFailed() {
        manageFlightsView.userCreationFailed();
    }


}
