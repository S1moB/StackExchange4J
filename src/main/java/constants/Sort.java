package constants;

public enum Sort {

    VOTES("votes"),
    ACTIVITY("activity"),
    CREATION("creation"),
    RELEVANCE("relevance");

   private String value;

    Sort(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
