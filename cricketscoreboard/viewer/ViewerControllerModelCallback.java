package console.cricketscoreboard.viewer;

import console.cricketscoreboard.dto.Match;
import console.cricketscoreboard.dto.Player;
import console.cricketscoreboard.dto.Team;

import java.util.List;

public interface ViewerControllerModelCallback {
    void noTeamsFound();

    void showAllTeams(List<Team> teams);

    void showTeam(Team team);

    void noMatchFound();

    void showAllMatches(List<Match> matches);

    void showMatch(Match match);

    void noPlayersFound();

    void showPlayer(List<Player> players);
}
