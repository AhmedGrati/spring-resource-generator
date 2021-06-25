package utils;

public enum APITypeValues {
    GRAPHQL("GraphQL"), REST("Rest");
    private final String value;

    APITypeValues(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
