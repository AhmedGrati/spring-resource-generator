
package schematics;

import utils.APITypeValues;

public class GraphQL implements APIType {
    @Override public String decorateResourceWithAPIType() {
        return APITypeValues.GRAPHQL.getValue();
    }
}