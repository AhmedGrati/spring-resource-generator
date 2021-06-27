package utils;

public enum APITypeValues {
    /**
     * Value for GRAPHQL API.
     */
    GRAPHQL("GraphQL"),
    /**
     * Value for Rest API.
     */
    REST("Rest");

    /**
     * value attribute that specify the type of the api.
     */
    private final String value;

    APITypeValues(final String apiValue) {
        this.value = apiValue;
    }

    /**
     * @return String
     */
    public String getValue() {
        return value;
    }


}
