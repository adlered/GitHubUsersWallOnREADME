package pers.adlered.githubuserswallonreadme.log;

public class Logger {
    public static void log(String level, String text) {
        Logger.log("[" + level + "] " + text);
    }

    public static void log(String text) {
        System.out.println(text);
    }

    public static void log() {
        System.out.println();
    }
}
