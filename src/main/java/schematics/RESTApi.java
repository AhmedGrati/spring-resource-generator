package schematics;

import utils.APITypeValues;

public class RESTApi implements APIType {
    /**
     * @return String
     */
    @Override
    public String decorateResourceWithAPIType() {
        return APITypeValues.REST.getValue();
    }
}
