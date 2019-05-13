package constants;

public enum Sort {

    VOTES("votes");

   private String value;

    Sort(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
