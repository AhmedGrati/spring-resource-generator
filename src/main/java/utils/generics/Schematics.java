package utils.generics;

public enum Schematics {
    RESOURCE("Resource"),
    ENTITY("entity");

    String value;
    private Schematics(String value) {
        this.value = value;
    }
}
