package schematics;

import utils.APITypeValues;

public class Controller extends Resource{
    Controller(APIType apiType) {
        super(apiType);
    }
    @Override
    public Resource createResource() {
        if(super.getApiType().decorateResourceWithAPIType().equals(APITypeValues.REST.getValue())) {
            System.out.println("hey");
        }
        if(super.getApiType().decorateResourceWithAPIType().equals(APITypeValues.GRAPHQL.getValue())) {
            System.out.println("graphql");
        }
        return null;
    }
}
