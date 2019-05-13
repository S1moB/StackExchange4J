package models;

public final class Answer {

         /* "is_accepted": false,
              "score": 1,
              "last_activity_date": 1557738306,
              "last_edit_date": 1557738306,
              "creation_date": 1557737946,
              "answer_id": 56108925,
              "question_id": 56108874
      */

        private Owner owner;
        private boolean is_accepted;
        private int last_activity_date;
        private int last_edit_date;
        private int creation_date;
        private long answer_id;
        private long question_id;
        private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public boolean isIs_accepted() {
        return is_accepted;
    }

    public void setIs_accepted(boolean is_accepted) {
        this.is_accepted = is_accepted;
    }

    public int getLast_activity_date() {
        return last_activity_date;
    }

    public void setLast_activity_date(int last_activity_date) {
        this.last_activity_date = last_activity_date;
    }

    public int getLast_edit_date() {
        return last_edit_date;
    }

    public void setLast_edit_date(int last_edit_date) {
        this.last_edit_date = last_edit_date;
    }

    public int getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(int creation_date) {
        this.creation_date = creation_date;
    }

    public long getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(long answer_id) {
        this.answer_id = answer_id;
    }

    public long getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(long question_id) {
        this.question_id = question_id;
    }
}
