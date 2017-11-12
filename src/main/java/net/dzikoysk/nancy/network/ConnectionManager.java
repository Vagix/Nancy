package net.dzikoysk.nancy.network;

import org.webbitserver.WebSocketConnection;

import java.util.Map;

public class ConnectionManager {

    private final Map<WebSocketConnection, NetworkManager> map;

    public ConnectionManager(Map<WebSocketConnection, NetworkManager> map) {
        this.map = map;
    }

}
