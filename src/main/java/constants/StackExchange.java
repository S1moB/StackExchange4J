package constants;

public enum StackExchange {
    URL("https://api.stackexchange.com/2.2/");

    final String value;

    StackExchange(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
