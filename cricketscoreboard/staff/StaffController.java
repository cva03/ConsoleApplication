package console.cricketscoreboard.staff;

import console.cricketscoreboard.dto.Match;
import console.cricketscoreboard.dto.Team;

import java.util.HashMap;
import java.util.List;

public class StaffController implements StaffControllerViewCallback,StaffControllerModelCallback {
    private StaffViewCallback staffView;
    private StaffModelCallback staffModel;
    public StaffController(StaffView staffView) {
        this.staffView=staffView;
        this.staffModel=new StaffModel(this);
    }

    @Override
    public void addTeam(Team team) {
        staffModel.addTeam(team);
    }

    @Override
    public void getAllTeams() {
        staffModel.getAllTeams();
    }

    @Override
    public void getTeamsForMatch() {
        staffModel.getTeamsForMatch();
    }

    @Override
    public void addMatch(Match match) {
        staffModel.addMatch(match);
    }

    @Override
    public void getAllMatches() {
        staffModel.getAllMatches();
    }

    @Override
    public void getTeam(int teamId) {
        staffModel.getTeam(teamId);
    }

    @Override
    public void getMatch(int matchId) {
        staffModel.getMatch(matchId);
    }

    @Override
    public void teamCreationSuccessfull(Team team) {
        staffView.teamCreationSuccessfull(team);
    }

    @Override
    public void noTeamsFound() {
        staffView.noTeamsFound();
    }

    @Override
    public void teamsFound(List<Team> teams) {
        staffView.teamsFound(teams);
    }

    @Override
    public void notEnoughtTeams() {
        staffView.notEnoughtTeams();
    }

    @Override
    public void teamsFoundForMatch(HashMap<Integer, Team> teams) {
        staffView.teamsFoundForMatch(teams);
    }

    @Override
    public void matchAddSuccess(Match match) {
        staffView.matchAddSuccess(match);
    }

    @Override
    public void noMatchFound() {
        staffView.noMatchFound();
    }

    @Override
    public void showAllMatches(List<Match> matches) {
        staffView.showAllMatches(matches);
    }

    @Override
    public void showTeam(Team team) {
        staffView.showTeam(team);
    }

    @Override
    public void showMatch(Match match) {
        staffView.showMatch(match);
    }
}
