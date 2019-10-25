package pers.adlered.githubuserswallonreadme.value;

import pers.adlered.githubuserswallonreadme.value.bind.UserAndAvatar;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Statics {
    public static List<UserAndAvatar> users = new ArrayList<>();
    public static ExecutorService executor = Executors.newSingleThreadExecutor();
    public static int columns = 3;
    public static int processing = 0;
    public static int count = 1;
}
