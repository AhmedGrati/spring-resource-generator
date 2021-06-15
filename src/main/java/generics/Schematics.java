package generics;

public enum Schematics {
    RESOURCE("Resource"),
    ENTITY("entity");

    private String value;
    private Schematics(String value) {
        this.value = value;
    }
}
