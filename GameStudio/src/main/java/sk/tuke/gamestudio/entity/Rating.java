package sk.tuke.gamestudio.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "UniqueNumberAndStatus", columnNames = { "game", "username" }) })
public class Rating {
    @Id
    @GeneratedValue
    private int identity;
    @Column(nullable = false, length = 64)
    private String game;
    @Column(nullable = false, length = 64)
    private String username;
    @Column(columnDefinition = "INT CHECK(rating BETWEEN 1 AND 5) NOT NULL")
    private int rating;
    @Column(nullable = false)
    private Date rated_at;

    public Rating(String game, String username, int rating, Date rated_at){
        this.game = game;
        this.username = username;
        this.rating = rating;
        this.rated_at = rated_at;
    }

    public Rating(){}

    public Rating(int rating){
        this.rating = rating;
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

    public int getRating() {
        return rating;
    }

    public int getIdentity() {
        return identity;
    }


    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getRated_at() {
        return rated_at;
    }

    public void setRated_at(Date rated_at) {
        this.rated_at = rated_at;
    }

    @Override
    public String toString() {
        return username + " rated game " + rating + " /5. Rated at: " + rated_at;
    }
}
