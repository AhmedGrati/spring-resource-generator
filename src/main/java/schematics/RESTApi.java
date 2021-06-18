package schematics;

public class RESTApi implements APIType{
    @Override
    public String decorateResourceWithAPIType() {
       return "REST";
    }
}
