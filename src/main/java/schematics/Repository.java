package schematics;

public class Repository extends Resource{
    Repository(APIType apiType) {
        super(apiType);
    }
    @Override
    public Resource createResource(APIType apiType) {
        return null;
    }
}
