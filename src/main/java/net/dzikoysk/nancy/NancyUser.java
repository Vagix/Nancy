package net.dzikoysk.nancy;

import net.dzikoysk.nancy.game.Player;

import java.util.UUID;

public class NancyUser {

    private final UUID userId;
    private final String login;
    private String displayName;

    public NancyUser(UUID userId, String login) {
        this.userId = userId;
        this.login = login;
    }

    public Player createPlayer() {
        return new Player(this);
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getLogin() {
        return login;
    }

    public UUID getUserId() {
        return userId;
    }

}
