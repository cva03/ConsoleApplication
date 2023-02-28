package console.cricketscoreboard.staff;

import console.cricketscoreboard.dto.Match;
import console.cricketscoreboard.dto.Team;

import java.util.HashMap;
import java.util.List;

public interface StaffViewCallback {
    void teamCreationSuccessfull(Team team);

    void noTeamsFound();

    void teamsFound(List<Team> teams);

    void notEnoughtTeams();

    void teamsFoundForMatch(HashMap<Integer,Team> teams);

    void matchAddSuccess(Match match);

    void noMatchFound();

    void showAllMatches(List<Match> matches);

    void showTeam(Team team);

    void showMatch(Match match);
}
