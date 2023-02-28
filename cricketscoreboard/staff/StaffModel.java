package console.cricketscoreboard.staff;


import console.cricketscoreboard.dto.Match;
import console.cricketscoreboard.dto.Team;
import console.cricketscoreboard.repository.Repository;

import java.util.HashMap;
import java.util.List;

public class StaffModel implements StaffModelCallback {
    private StaffControllerModelCallback staffController;
    private Repository data=Repository.getInstance();
    public StaffModel(StaffController staffController) {
        this.staffController=staffController;
    }

    @Override
    public void addTeam(Team team) {
        data.addTeam(team);
        staffController.teamCreationSuccessfull(team);
    }

    @Override
    public void getAllTeams() {
        List<Team> teams=data.getAllTeams();
        if(teams.isEmpty()){
            staffController.noTeamsFound();
        }else{
            staffController.teamsFound(teams);
        }
    }

    @Override
    public void getTeamsForMatch() {
        HashMap<Integer,Team> teams=data.getAllTeamsForMatch();
        if(teams.size()<=1){
            staffController.notEnoughtTeams();
        }else{
            staffController.teamsFoundForMatch(teams);
        }
    }

    @Override
    public void addMatch(Match match) {
        data.addMatch(match);
        staffController.matchAddSuccess(match);
    }

    @Override
    public void getAllMatches() {
        List<Match> matches=data.getAllMatches();
        if(matches.isEmpty()){
            staffController.noMatchFound();
        }else{
            staffController.showAllMatches(matches);
        }
    }

    @Override
    public void getTeam(int teamId) {
        staffController.showTeam(data.getTeam(teamId));
    }

    @Override
    public void getMatch(int matchId) {
        staffController.showMatch(data.getMatch(matchId));
    }


}
