package schematics;

public class Controller extends Resource{
    Controller(APIType apiType) {
        super(apiType);
    }
    @Override
    public Resource createResource(APIType apiType) {
        return null;
    }
}
