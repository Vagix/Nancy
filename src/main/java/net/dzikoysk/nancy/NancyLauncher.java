package net.dzikoysk.nancy;

public class NancyLauncher {

    public static void main(String[] args) throws Exception {
        NancyServer server = new NancyServer();
        server.launch();
    }

}
