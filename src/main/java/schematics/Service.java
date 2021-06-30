package schematics;

public class Service extends Resource {
    Service(final APIType apiType) {
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
