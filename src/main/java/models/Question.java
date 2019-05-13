package models;

import java.util.List;

public final class Question {

    /*
    * {
      "tags": [
        "vue.js",
        "vuetify.js",
        "stylus"
      ],
      "owner": {
        "reputation": 104,
        "user_id": 9266540,
        "user_type": "registered",
        "profile_image": "https://www.gravatar.com/avatar/2821f32308af9261e10fdcc522490874?s=128&d=identicon&r=PG&f=1",
        "display_name": "Michael",
        "link": "https://stackoverflow.com/users/9266540/michael"
      },
      "is_answered": false,
      "view_count": 1,
      "answer_count": 0,
      "score": 0,
      "last_activity_date": 1557737512,
      "creation_date": 1557737512,
      "question_id": 56108805,
      "link": "https://stackoverflow.com/questions/56108805/issue-with-stylus-and-vuetify",
      "title": "Issue with Stylus and Vuetify"
    }*/
    private boolean is_answered;
    private int view_count;
    private int answer_count;
    private int score;
    private int last_activity_date;
    private int creation_date;
    private int question_id;
    private String link;
    private String title;
    private Owner owner;
    private List<String> tags;
    private String body;

    public Question() {
    }

    public boolean isIs_answered() {
        return is_answered;
    }

    public void setIs_answered(boolean is_answered) {
        this.is_answered = is_answered;
    }

    public int getView_count() {
        return view_count;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }

    public int getAnswer_count() {
        return answer_count;
    }

    public void setAnswer_count(int answer_count) {
        this.answer_count = answer_count;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLast_activity_date() {
        return last_activity_date;
    }

    public void setLast_activity_date(int last_activity_date) {
        this.last_activity_date = last_activity_date;
    }

    public int getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(int creation_date) {
        this.creation_date = creation_date;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}