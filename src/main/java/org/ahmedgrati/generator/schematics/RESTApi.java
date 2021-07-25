package org.ahmedgrati.generator.schematics;


import org.ahmedgrati.generator.utils.APITypeValues;

public class RESTApi implements APIType {
    /**
     * @return String
     */
    @Override
    public String decorateResourceWithAPIType() {
        return APITypeValues.REST.getValue();
    }
}
