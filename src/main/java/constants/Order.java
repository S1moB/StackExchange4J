package constants;

public enum Order {
    ASC("asc"),DESC("desc");

    String value;

    Order(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }

}
