package schematics;

public abstract class Resource {
    private APIType apiType;
    Resource(APIType apiType) {
        this.apiType = apiType;
    }

    public APIType getApiType() {
        return apiType;
    }

    public void setApiType(APIType apiType) {
        this.apiType = apiType;
    }

    public abstract Resource createResource();
}
