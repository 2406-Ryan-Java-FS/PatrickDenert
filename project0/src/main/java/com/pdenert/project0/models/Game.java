package com.pdenert.project0.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="games")
public class Game {
    @Column(name="game_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer game_id;

    @Column(name="name", nullable = false, unique = true)
    private String name;

    @Column(name="rating")
    private Integer rating;

    @Column(name="players")
    private Integer players;

    @Column(name="online")
    private Boolean online;

    @Column(name="genre")
    private String genre;

    public Game() {
    }

    public Game(Integer game_id, String name, Integer rating, Integer players, Boolean online, String genre) {
        this.game_id = game_id;
        this.name = name;
        this.rating = rating;
        this.players = players;
        this.online = online;
        this.genre = genre;
    }

    public Integer getGame_id() {
        return game_id;
    }

    public String getName() {
        return name;
    }

    public Integer getRating() {
        return rating;
    }

    public Integer getPlayers() {
        return players;
    }

    public Boolean getOnline() {
        return online;
    }

    public String getGenre() {
        return genre;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setPlayers(Integer players) {
        this.players = players;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(game_id, game.game_id) && Objects.equals(name, game.name) && Objects.equals(rating, game.rating) && Objects.equals(players, game.players) && Objects.equals(online, game.online) && Objects.equals(genre, game.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game_id, name, rating, players, online, genre);
    }

    @Override
    public String toString() {
        return "Game{" +
                "game_id=" + game_id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", players=" + players +
                ", online=" + online +
                ", genre='" + genre + '\'' +
                '}';
    }
}
