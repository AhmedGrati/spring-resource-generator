package schematics;

public class Repository extends Resource {
    Repository(final APIType apiType) {
        super(apiType);
    }

    /**
     * @return {@link schematics.Resource} Resource
     */
    @Override
    public Resource createResource() {
        return null;
    }
}
