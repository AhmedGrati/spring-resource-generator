package org.ahmedgrati.generator.schematics;


import org.ahmedgrati.generator.utils.APITypeValues;

public final class Controller extends Resource {

    /**
     * Public Controller Constructor.
     * @param apiType
     */
    public Controller(final APIType apiType) {
        super(apiType);
    }

    /**
     * @return {@link org.ahmedgrati.generator.schematics.Resource} Resource
     */
    @Override
    public Resource createResource() {
        if (super.getApiType().decorateResourceWithAPIType().equals(APITypeValues.REST.getValue())) {
            System.out.println("hey");
        }
        if (super.getApiType().decorateResourceWithAPIType().equals(APITypeValues.GRAPHQL.getValue())) {
            System.out.println("graphql");
        }
        return null;
    }
}
