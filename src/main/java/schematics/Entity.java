package schematics;

public class Entity extends Resource{

    Entity(APIType apiType) {
        super(apiType);
    }

    @Override
    public Resource createResource(APIType apiType) {
        return null;
    }
}
