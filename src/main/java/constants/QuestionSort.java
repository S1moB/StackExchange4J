package constants;

public enum QuestionSort {

    VOTES("votes"),
    ACTIVITY("activity"),
    CREATION("creation");

    private String value;

    QuestionSort(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
