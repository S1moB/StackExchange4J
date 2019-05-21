package constants;

public enum SearchSort {

    VOTES("votes"),
    ACTIVITY("activity"),
    CREATION("creation"),
    RELEVANCE("relevance");

   private String value;

    SearchSort(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
