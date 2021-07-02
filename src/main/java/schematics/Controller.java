package schematics;

import utils.APITypeValues;

public final class Controller extends Resource {
    Controller(final APIType apiType) {
        super(apiType);
    }

    /**
     * @return {@link schematics.Resource} Resource
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
