package schematics;

public class Entity extends Resource{

    public Entity(APIType apiType) {
        super(apiType);
    }

    @Override
    public Resource createResource() {
        return null;
    }
}
