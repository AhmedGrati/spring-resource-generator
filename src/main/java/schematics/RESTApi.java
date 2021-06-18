package schematics;

import utils.APITypeValues;

public class RESTApi implements APIType{
    @Override
    public String decorateResourceWithAPIType() {
       return APITypeValues.REST.getValue();
    }
}
