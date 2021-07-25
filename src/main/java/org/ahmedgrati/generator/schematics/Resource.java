package org.ahmedgrati.generator.schematics;

public abstract class Resource {
    /**
     * Class attribute which represent the api type.
     */
    private APIType apiType;

    Resource(final APIType apiTypeValue) {
        this.apiType = apiTypeValue;
    }

    /**
     * @return {@link APIType} APIType
     */
    public APIType getApiType() {
        return apiType;
    }

    /**
     * @param apiTypeValue
     */
    public void setApiType(final APIType apiTypeValue) {
        this.apiType = apiTypeValue;
    }

    /**
     * @return {@link org.ahmedgrati.generator.schematics.Resource} Resource
     */
    public abstract Resource createResource();
}
