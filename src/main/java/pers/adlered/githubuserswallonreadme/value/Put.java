package pers.adlered.githubuserswallonreadme.value;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import javafx.beans.binding.StringBinding;
import jdk.nashorn.internal.parser.JSONParser;
import pers.adlered.githubuserswallonreadme.log.Logger;
import pers.adlered.githubuserswallonreadme.value.bind.UserAndAvatar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Stack;

public class Put extends Thread {
    private String userLinkOrName = "";

    public Put(String userLinkOrName) {
        this.userLinkOrName = userLinkOrName;
    }

    @Override
    public void run() {
        String realName = "";
        if (userLinkOrName.contains("github.com")) {
            // 除去链接，获取真实用户名
            String[] getRealName = userLinkOrName.split("/");
            realName = getRealName[getRealName.length - 1];
        } else {
            realName = userLinkOrName;
        }
        String[] avatar = getAvatar(realName);
        if (!avatar[1].isEmpty()) {
            realName = avatar[1];
        }
        Statics.users.add(new UserAndAvatar("https://github.com/" + realName, avatar[0], realName));
        Statics.processing--;
    }

    private String[] getAvatar(String realName) {
        // 通过接口读取用户头像
        StringBuilder json = new StringBuilder();
        try {
            URL urlObject = new URL("https://api.github.com/users/" + realName);
            URLConnection uc = urlObject.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(),"UTF-8"));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
            JSONObject jsonObject = JSON.parseObject(json.toString());
            return new String[] {jsonObject.get("avatar_url").toString(), jsonObject.get("login").toString()};
        } catch (IOException e) {
            Logger.log("ERROR", "The request failed and the number of GitHub API requests may have reached the limit. Please try again in an hour.");
            Logger.log("INPUT", Statics.count + " :: Input a GitHub UserLink Or GitHub Username: ");
            System.out.print("> ");
            return new String[] {"https://avatars3.githubusercontent.com/u/18028768?v=4", ""};
        }
    }
}
