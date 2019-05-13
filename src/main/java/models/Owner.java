package models;

public final class Owner {
    /*
    * "owner": {
        "reputation": 104,
        "user_id": 9266540,
        "user_type": "registered",
        "profile_image": "https://www.gravatar.com/avatar/2821f32308af9261e10fdcc522490874?s=128&d=identicon&r=PG&f=1",
        "display_name": "Michael",
        "link": "https://stackoverflow.com/users/9266540/michael"
      }*/
    private int user_id;
    private String user_type;
    private String profile_image;
    private String display_name;
    private String link;
    private int reputation;

    public Owner(){}

    public int getUser_id() {
        return user_id;
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

    public void setUser_id(int user_id) {
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
