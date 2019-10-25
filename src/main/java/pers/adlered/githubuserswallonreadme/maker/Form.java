package pers.adlered.githubuserswallonreadme.maker;

import pers.adlered.githubuserswallonreadme.value.Statics;
import pers.adlered.githubuserswallonreadme.value.bind.UserAndAvatar;

import java.util.List;

public class Form {
    public static String markdown(List<UserAndAvatar> userAndAvatarList) {
        StringBuilder sb = new StringBuilder();
        int columns = Statics.columns;
        if (columns > userAndAvatarList.size()) {
            columns = userAndAvatarList.size();
        }
        // 构建表头
        sb.append("|");
        for (int i = 0; i < columns; i++) {
            sb.append(":construction_worker:|");
        }
        sb.append("\n");
        // 创建分隔符
        sb.append("|");
        for (int i = 0; i < columns; i++) {
            sb.append(":-------------------:|");
        }
        sb.append("\n");
        int count = 0;
        while (count < userAndAvatarList.size()) {
            sb.append("|");
            for (int i = 0; i < columns; i++) {
                try {
                    sb.append("<img height='48' width='48' src='" + userAndAvatarList.get(count + i).getUserAvatar() + "'>");
                } catch (IndexOutOfBoundsException e) {
                    break;
                } finally {
                    sb.append("|");
                }
            }
            sb.append("\n");
            sb.append("|");
            for (int i = 0; i < columns; i++) {
                try {
                sb.append("[@" + userAndAvatarList.get(count + i).getUsername() + "](" + userAndAvatarList.get(count + i).getUserLink() + ")");
                } catch (IndexOutOfBoundsException e) {
                    break;
                } finally {
                    sb.append("|");
                }
            }
            sb.append("\n");
            count += columns;
        }
        return sb.toString();
    }
}
