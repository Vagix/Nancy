package net.dzikoysk.nancy.util;

public class TimeUtils {

    public static double getUptime(long period) {
        long uptime = System.currentTimeMillis() - period;
        return uptime / 1000.0D;
    }

}
