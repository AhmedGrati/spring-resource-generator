package org.ahmedgrati.generator.schematics;

public class Repository extends Resource {
    Repository(final APIType apiType) {
        super(apiType);
    }

    /**
     * @return {@link org.ahmedgrati.generator.schematics.Resource} Resource
     */
    @Override
    public Resource createResource() {
        return null;
    }
}
