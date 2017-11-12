package net.dzikoysk.nancy.network;

public interface MessageListener {

    void handle(NetworkManager networkManager, String message);

}
