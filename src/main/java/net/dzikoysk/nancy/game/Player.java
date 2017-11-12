package net.dzikoysk.nancy.game;

import net.dzikoysk.nancy.NancyUser;

public class Player {

    private final NancyUser user;
    private String color;
    private int points;
    private int kills;
    private int lives;

    public Player(NancyUser user) {
        this.user = user;
    }

    public String getColor() {
        return color;
    }

    public int getKills() {
        return kills;
    }

    public int getLives() {
        return lives;
    }

    public int getPoints() {
        return points;
    }

    public NancyUser getUser() {
        return user;
    }

}
