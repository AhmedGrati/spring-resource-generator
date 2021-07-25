package org.ahmedgrati.generator.schematics;

public class Entity extends Resource {

    /**
     * Public Entity Constructor.
     * @param apiType
     */
    public Entity(final APIType apiType) {
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
