package models;

public final class Owner {
    private int reputation;
    private long user_id;

    private String user_type;
    private String profile_image;
    private String display_name;
    private String link;

    public Owner() {
    }


    public String getUser_type() {
        return user_type;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public String getLink() {
        return link;
    }

    public int getReputation() {
        return reputation;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }


    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }


    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }


    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }
}
