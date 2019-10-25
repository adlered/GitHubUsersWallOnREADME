package pers.adlered.githubuserswallonreadme.value.bind;

public class UserAndAvatar {
    private String userLink;
    private String userAvatar;
    private String username;

    public UserAndAvatar(String userLink, String userAvatar, String username) {
        this.userLink = userLink;
        this.userAvatar = userAvatar;
        this.username = username;
    }

    public String getUserLink() {
        return userLink;
    }

    public void setUserLink(String userLink) {
        this.userLink = userLink;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
