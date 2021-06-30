
package schematics;

import utils.APITypeValues;

public class GraphQL implements APIType {
    /**
     * The method decorate the graphql entity with a specific type.
     * @return String
     */
    @Override
    public String decorateResourceWithAPIType() {
        return APITypeValues.GRAPHQL.getValue();
    }
}
