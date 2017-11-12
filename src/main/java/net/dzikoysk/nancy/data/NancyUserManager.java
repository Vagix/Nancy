package net.dzikoysk.nancy.data;

import net.dzikoysk.nancy.NancyServer;
import net.dzikoysk.nancy.NancyUser;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NancyUserManager {

    private final NancyServer server;
    private final Map<String, NancyUser> users = new HashMap<>();

    public NancyUserManager(NancyServer nancyServer) {
        this.server = nancyServer;
    }

    public NancyUser getUser(String login) {
        NancyUser user = users.get(login);

        // TODO: Database # loadUser
        if (user == null) {
            UUID userId = UUID.fromString("TODO:" + login);
            user = new NancyUser(userId, login);
            users.put(login, user);
        }

        return user;
    }

    public void unloadUser(String login) {
        // TODO: clear cache
    }

}
