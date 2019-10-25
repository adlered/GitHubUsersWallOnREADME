package pers.adlered.githubuserswallonreadme.main;

import pers.adlered.githubuserswallonreadme.actuator.ConsoleListen;
import pers.adlered.githubuserswallonreadme.log.Logger;
import pers.adlered.githubuserswallonreadme.maker.Form;
import pers.adlered.githubuserswallonreadme.push.Help;
import pers.adlered.githubuserswallonreadme.value.Put;
import pers.adlered.githubuserswallonreadme.value.Statics;

public class Main {
    public static void main(String[] args) {
        Help.firstHelp();
        String last = "";
        while (true) {
            System.out.println(Statics.count + " :: Input a GitHub UserLink Or GitHub Username: ");
            System.out.print("> ");
            last = ConsoleListen.listen();
            if (last.equals("q!")) {
                break;
            }
            Statics.executor.execute(new Put(last));
            Statics.processing++;
            Statics.count++;
            Logger.log("Processing \"" + last + "\" in background.");
        }
        while (true) {
            if (Statics.processing != 0) {
                System.out.println(Statics.processing + " thread(s) still processing, please wait...");
            } else {
                break;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Statics.executor.shutdownNow();
        String result = Form.markdown(Statics.users);
        Logger.log("Result: ");
        System.out.println(result);
    }
}
