package console.cricketscoreboard.staff;

import console.cricketscoreboard.dto.Match;
import console.cricketscoreboard.dto.Team;

public interface StaffControllerViewCallback {
    void addTeam(Team team);

    void getAllTeams();

    void getTeamsForMatch();

    void addMatch(Match match);

    void getAllMatches();

    void getTeam(int teamId);

    void getMatch(int matchId);
}
