package console.cricketscoreboard.viewer;


import console.cricketscoreboard.dto.Match;
import console.cricketscoreboard.dto.Player;
import console.cricketscoreboard.dto.Team;
import console.cricketscoreboard.repository.Repository;

import java.util.List;

public class ViewerModel implements ViewerModelCallback {
    private ViewerControllerModelCallback viewerController;
    private Repository data=Repository.getInstance();
    public ViewerModel(ViewerController viewerController) {
        this.viewerController =viewerController;
    }

    @Override
    public void getAllTeams() {
        List<Team> teams=data.getAllTeams();
        if(teams.isEmpty()){
            viewerController.noTeamsFound();
        }else{
            viewerController.showAllTeams(teams);
        }
    }

    @Override
    public void getTeam(int teamId) {
        viewerController.showTeam(data.getTeam(teamId));
    }

    @Override
    public void getAllMatches() {
        List<Match> matches=data.getAllMatches();
        if(matches.isEmpty()){
            viewerController.noMatchFound();
        }else{
            viewerController.showAllMatches(matches);
        }
    }

    @Override
    public void getMatch(int matchId) {
        viewerController.showMatch(data.getMatch(matchId));
    }

    @Override
    public void getAllPlayers() {
        List<Player> players=data.getAllPlayers();
        if(players.isEmpty()){
            viewerController.noPlayersFound();
        }else{
            viewerController.showPlayer(players);
        }
    }
}
