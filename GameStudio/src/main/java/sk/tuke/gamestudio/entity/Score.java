package sk.tuke.gamestudio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Score implements Serializable {
    @Id
    @GeneratedValue
    private int identity;
    private String game;
    private String username;
    private int points;
    private Date playedAt;

    public Score(String game, String username, int points, Date playedAt) {
        this.game = game;
        this.username = username;
        this.points = points;
        this.playedAt = playedAt;
    }

    public Score(){};

    public int getIdentity() {
        return identity;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Date getPlayedAt() {
        return playedAt;
    }

    public void setPlayedAt(Date playedAt) {
        this.playedAt = playedAt;
    }

    @Override
    public String toString() {
        return username + " achieved " + points + " points. Game played at " + playedAt;
    }
}
