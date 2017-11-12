package net.dzikoysk.nancy;

public class NancyShutdown extends Thread {

    private final NancyServer server;

    public NancyShutdown(NancyServer server) {
        this.server = server;
    }

    @Override
    public void run() {
        this.server.shutdown();
    }

}
