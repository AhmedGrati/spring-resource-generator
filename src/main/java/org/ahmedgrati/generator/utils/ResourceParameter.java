package org.ahmedgrati.generator.utils;

import java.util.Arrays;

public enum ResourceParameter {
    ENTITY("entity"),
    SERVICE("service"),
    RESOURCE("resource"),
    RESOLVER("resolver"),
    CONTROLLER("controller"),
    REPOSITORY("repository");

    private final String value;

    ResourceParameter(final String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static ResourceParameter from(final String value) {
        return Arrays.stream(values())
                .filter(element -> element.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("The argument "
                        + value + " doesn't match any available resources."));
    }
}
