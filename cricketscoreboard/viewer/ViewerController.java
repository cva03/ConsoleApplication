package console.cricketscoreboard.viewer;

import console.cricketscoreboard.dto.Match;
import console.cricketscoreboard.dto.Player;
import console.cricketscoreboard.dto.Team;

import java.util.List;

public class ViewerController implements ViewerControllerViewCallback,ViewerControllerModelCallback{
    private ViewerViewCallback viewerView;
    private ViewerModelCallback viewerModel;

    public ViewerController(ViewerView viewerView) {
        this.viewerView=viewerView;
        this.viewerModel=new ViewerModel(this);
    }

    @Override
    public void getAllTeams() {
        viewerModel.getAllTeams();
    }

    @Override
    public void getTeam(int teamId) {
        viewerModel.getTeam(teamId);
    }

    @Override
    public void getAllMatches() {
        viewerModel.getAllMatches();
    }

    @Override
    public void getMatch(int matchId) {
        viewerModel.getMatch(matchId);
    }

    @Override
    public void getAllPlayers() {
        viewerModel.getAllPlayers();
    }

    @Override
    public void noTeamsFound() {
        viewerView.noTeamsFound();
    }

    @Override
    public void showAllTeams(List<Team> teams) {
        viewerView.showAllTeams(teams);
    }

    @Override
    public void showTeam(Team team) {
        viewerView.showTeam(team);
    }

    @Override
    public void noMatchFound() {
        viewerView.noMatchFound();
    }

    @Override
    public void showAllMatches(List<Match> matches) {
        viewerView.showAllMatches(matches);
    }

    @Override
    public void showMatch(Match match) {
        viewerView.showMatch(match);
    }

    @Override
    public void noPlayersFound() {
        viewerView.noPlayerFound();
    }

    @Override
    public void showPlayer(List<Player> players) {
        viewerView.showPlayer(players);
    }
}
