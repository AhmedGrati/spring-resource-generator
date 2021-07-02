package schematics;

public interface AbstractResourceFactory {

    /**
     * @return {@link schematics.Resource}
     */
    Resource  createResource();

}
