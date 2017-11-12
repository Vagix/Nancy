package net.dzikoysk.nancy.network;

import net.dzikoysk.nancy.NancyServer;
import net.dzikoysk.nancy.network.client.MessageClientHandler;
import org.webbitserver.BaseWebSocketHandler;
import org.webbitserver.WebSocketConnection;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class ConnectionHandler extends BaseWebSocketHandler {

    private final Map<String, NetworkManager> networkManagers = new HashMap<>();

    @Override
    public void onOpen(WebSocketConnection connection) throws Exception {
        NetworkManager networkManager = new NetworkManager(connection);
        networkManagers.put(networkManager.getHost(), networkManager);

        NancyServer.getLogger().info("/" + networkManager.getHost() + " connected");
        super.onOpen(connection);

        networkManager.addMessageListener(new MessageClientHandler());
    }

    @Override
    public void onClose(WebSocketConnection connection) throws Exception {
        String host = connection.httpRequest().header("host");

        NetworkManager networkManager = networkManagers.get(host);
        networkManager.close();

        networkManagers.remove(host);
        super.onClose(connection);

        NancyServer.getLogger().info("/" + networkManager.getHost() + " disconnected");
    }

    @Override
    public void onMessage(WebSocketConnection connection, String msg) throws Throwable {
        String host = connection.httpRequest().header("host");

        NetworkManager networkManager = networkManagers.get(host);
        networkManager.onMessage(msg);

        super.onMessage(connection, msg);
    }

    @Override
    public void onMessage(WebSocketConnection connection, byte[] msg) throws Throwable {
        this.onMessage(connection, new String(msg, Charset.forName("UTF-8")));
    }

    @Override
    public void onPing(WebSocketConnection connection, byte[] msg) throws Throwable {
        super.onPing(connection, msg);
    }

    @Override
    public void onPong(WebSocketConnection connection, byte[] msg) throws Throwable {
        super.onPong(connection, msg);
    }

}
