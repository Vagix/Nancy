package net.dzikoysk.nancy.network;

import org.webbitserver.WebSocketConnection;

import java.util.ArrayList;
import java.util.Collection;

public class NetworkManager {

    private String host;
    private WebSocketConnection connection;
    private Collection<MessageListener> messageListeners;

    public NetworkManager(WebSocketConnection connection) {
        this.connection = connection;
        this.messageListeners = new ArrayList<>(1);
        this.host = connection.httpRequest().header("Host");
    }

    public void close() {
        connection.close();
    }

    public void onMessage(String message) {
        for (MessageListener messageListener : messageListeners) {
            messageListener.handle(this, message);
        }
    }

    public void addMessageListener(MessageListener messageListener) {
        messageListeners.add(messageListener);
    }

    public WebSocketConnection getConnection() {
        return connection;
    }

    public String getHost() {
        return host;
    }

}
