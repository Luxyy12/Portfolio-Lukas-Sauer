package sk.tuke.gamestudio.service;

import sk.tuke.gamestudio.entity.Score;
import sk.tuke.gamestudio.exceptions.ServiceException;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ScoreServiceJdbc implements ScoreService{

    private static final String JDBC_URL = "jdbc:postgresql://localhost/Gamestudio2";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "postgres";

    final String STATEMENT_ADD_SCORE = "INSERT INTO score VALUES (?, ?, ?, ?)";

    @Override
    public void addScore(Score score) {
        try(
            var connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            var statement = connection.prepareStatement(STATEMENT_ADD_SCORE);
        )
        {
            statement.setString(1, score.getGame());
            statement.setString(2, score.getUsername());
            statement.setInt(3, score.getPoints());
            statement.setTimestamp(4, new Timestamp(score.getPlayedAt().getTime()));
            statement.executeUpdate();
        }catch (SQLException e){
            throw new ServiceException(e);
        }
    }


    @Override
    public List<Score> getBestScores(String game) {
        final String STATEMENT_BEST_SCORES = "SELECT game, username, points, played_at FROM score WHERE game= ? ORDER BY points DESC LIMIT 5";

        try( var connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             var statement = connection.prepareStatement(STATEMENT_BEST_SCORES)
        )
        {
            statement.setString(1,game);
            try(var rs = statement.executeQuery()){
                var scores= new ArrayList<Score>();
                while(rs.next()) {
                    scores.add(new Score(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getTimestamp(4)));
                }
                return scores;
            }
        }catch (SQLException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void reset() {
        final String STATEMENT_RESET = "DELETE FROM score";
        try(var connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            var statement = connection.createStatement()
            )
        {
            statement.executeUpdate(STATEMENT_RESET);
        }catch(SQLException e){
            throw new ServiceException(e);
        }
    }
}

