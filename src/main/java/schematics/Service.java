package schematics;

public class Service extends Resource{
    Service(APIType apiType) {
        super(apiType);
    }
    @Override
    public Resource createResource() {
        return null;
    }
}
