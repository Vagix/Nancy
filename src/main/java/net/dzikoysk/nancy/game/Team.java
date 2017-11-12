package net.dzikoysk.nancy.game;

import java.util.ArrayList;
import java.util.Collection;

public class Team {

    private final GameArea gameArea;
    private final Collection<Player> members = new ArrayList<>();

    public Team(GameArea gameArea) {
        this.gameArea = gameArea;
    }

    public Collection<Player> getMembers() {
        return members;
    }

    public GameArea getGameArea() {
        return gameArea;
    }

}
