package org.ahmedgrati.generator.actions;


import org.ahmedgrati.generator.schematics.Resource;

public interface AbstractAction {

    /**
     * @param resource
     * @param resourceName
     * @throws Exception
     */
    void execute(Resource resource, String resourceName) throws Exception;
}
