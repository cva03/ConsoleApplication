package console.cricketscoreboard.viewer;

public interface ViewerControllerViewCallback {
    void getAllTeams();

    void getTeam(int teamId);

    void getAllMatches();

    void getMatch(int matchId);

    void getAllPlayers();
}
