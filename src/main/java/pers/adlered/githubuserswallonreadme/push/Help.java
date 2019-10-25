package pers.adlered.githubuserswallonreadme.push;

import pers.adlered.githubuserswallonreadme.actuator.ConsoleListen;
import pers.adlered.githubuserswallonreadme.log.Logger;
import pers.adlered.githubuserswallonreadme.value.Statics;

public class Help {
    public static void firstHelp() {
        StringBuilder sb = new StringBuilder();
        sb.append("Generator of GitHub project's avatar wall.\n")
                .append("Please input user's GitHub profile link or user's name.\n")
                .append("Input \"q!\" to start a generation.");
        Logger.log("HELP", sb.toString());
        Logger.log("INPUT", "Set column number: ");
        System.out.print("> ");
        int columns = -1;
        try {
            columns = Integer.parseInt(ConsoleListen.listen());
        } catch (NumberFormatException e) {
            Logger.log("ERROR", "Invalid column number! Using default: 3");
        }
        if (columns != -1) {
            Statics.columns = columns;
        }
    }
}
