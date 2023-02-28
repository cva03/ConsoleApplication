package console.cricketscoreboard.viewer;

import console.cricketscoreboard.dto.Match;
import console.cricketscoreboard.dto.Player;
import console.cricketscoreboard.dto.Team;
import console.cricketscoreboard.login.LoginView;

import java.util.List;
import java.util.Scanner;

public class ViewerView implements ViewerViewCallback {
    private ViewerControllerViewCallback viewerController;
    private Scanner sc=new Scanner(System.in);
    public ViewerView(){
        this.viewerController=new ViewerController(this);
    }

    public void init(){
        start();
    }

    private void start(){
        while (true) {
            System.out.printf("%50s","<---- Viewer site ---->");
            System.out.println("\n1. Show all teams");
            System.out.println("2. Show all matches");
            System.out.println("3. List all Player");
            System.out.println("4. Go to login page");
            System.out.println("Enter your choice");
            try {
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        viewerController.getAllTeams();
                        break;
                    case 2:
                        viewerController.getAllMatches();
                        break;
                    case 3:
                        viewerController.getAllPlayers();
                        break;
                    case 4:
                        LoginView lv=new LoginView();
                        lv.init();
                    default:
                        throw new RuntimeException();
                }
            } catch (Exception e) {
                System.out.println("Invalid Input!");
            }
        }
    }

    @Override
    public void noTeamsFound() {

    }

    @Override
    public void showAllTeams(List<Team> teams) {
        System.out.println("<----- Team list ----->");
        System.out.println(teams.size()+" teams found:");
        System.out.printf("\n%-15s%-20s%-15s%-15s%-15s%-15s\n","TeamId","Team-Name","Total-Matches","Wins","Loses","Draws");
        for(Team team:teams){
            team.print();
        }
        while (true){
            try {
                System.out.println("Enter the TeamId to show more information about the team or 0 to Exit");
                int teamId=sc.nextInt();
                sc.nextLine();
                if(teamId==0){
                    System.out.println("Returning to main menu!");
                    pressAnyKey();
                }
                if(teamId>teams.size()){
                    throw new NumberFormatException();
                }
                viewerController.getTeam(teamId);
            }catch (NumberFormatException e){
                System.out.println("Enter valid teamId");
            }
        }
    }

    @Override
    public void showTeam(Team team) {
        team.printSpecific();
        pressAnyKey();
    }

    @Override
    public void noMatchFound() {
        System.out.println("No matches started yet");
        pressAnyKey();
    }

    @Override
    public void showAllMatches(List<Match> matches) {
        System.out.println("<----- Match list ----->");
        System.out.println(matches.size()+" matches found:");
        System.out.printf("\n%-15s%-40s%-15s%-15s%-20s%-20s%-20s%-20s\n","Match-Id","Match","Team1-Total","Team2-Total","Won","Lose","Draw","Man-Of-The-Match");
        for(Match match:matches){
            match.print();
        }
        while (true){
            try {
                System.out.println("Enter the Match-Id to show more information about the Match or 0 to Exit");
                int matchId=sc.nextInt();
                sc.nextLine();
                if(matchId==0){
                    System.out.println("Returning to main menu!");
                    pressAnyKey();
                }
                if(matchId>matches.size()){
                    throw new NumberFormatException();
                }
                viewerController.getMatch(matchId);
            }catch (NumberFormatException e){
                System.out.println("Enter valid teamId");
            }
        }
    }

    @Override
    public void showMatch(Match match) {
        match.printSpecificMatch();
        pressAnyKey();
    }

    @Override
    public void showPlayer(List<Player> players) {
        System.out.printf("\n%-15s%-20s%-15s\n","Player-Id","Name","Total-Runs");
        for(Player player:players){
            player.print();
        }
        System.out.println("Enter 1 to sort player according to their runs or 0 to Exit");
        String choice=sc.nextLine();
        if(choice.equals("1")){
            players.sort((p1, p2) -> p2.getTotalruns() - p1.getTotalruns());
            System.out.printf("\n%-15s%-20s%-15s\n","Player-Id","Name","Total-Runs");
            for(Player player:players){
                player.print();
            }
        }
        pressAnyKey();
    }

    @Override
    public void noPlayerFound() {
        System.out.println("No players registered yet");
        pressAnyKey();

    }

    public void pressAnyKey(){
        System.out.println("Press any key to go to Main-menu");
        sc.nextLine();
        start();
    }
}
