
package schematics;

public class GraphQL implements APIType {
    @Override public String decorateResourceWithAPIType() {
        return "GRAPHQL";
    }
}