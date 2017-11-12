package net.dzikoysk.nancy;

import net.dzikoysk.nancy.data.NancyUserManager;
import net.dzikoysk.nancy.network.ConnectionHandler;
import net.dzikoysk.nancy.util.TimeUtils;
import org.slf4j.Logger;
import org.webbitserver.WebServer;
import org.webbitserver.WebServers;

public class NancyServer {

    private WebServer webServer;
    private NancyUserManager userManager;
    private long uptime;

    public void launch() throws Exception {
        this.uptime = System.currentTimeMillis();
        getLogger().info("Launching NancyServer " + NancyConstants.VERSION);

        this.userManager = new NancyUserManager(this);
        this.webServer = WebServers.createWebServer(25500)
                .add("/nancy", new ConnectionHandler())
                .start()
                .get();

        Thread shutdownHook = new NancyShutdown(this);
        Runtime.getRuntime().addShutdownHook(shutdownHook);

        getLogger().info("Done! (" + TimeUtils.getUptime(uptime) + "s)");
    }

    public void shutdown() {
        webServer.stop();
        getLogger().info("Bye! (Uptime: " + TimeUtils.getUptime(uptime) + "s)");
    }

    public long getUptime() {
        return uptime;
    }

    public NancyUserManager getUserManager() {
        return userManager;
    }

    public WebServer getWebServer() {
        return webServer;
    }

    public static Logger getLogger() {
        return NancyLogger.NANCY_LOGGER;
    }

}
