package org.ahmedgrati.generator.actions;


import org.ahmedgrati.generator.schematics.Resource;
import org.ahmedgrati.generator.utils.ResourceParameter;

public interface AbstractAction {

    /**
     * @param resource
     * @param resourceName
     * @throws Exception
     */
    void execute(ResourceParameter resource, String resourceName, String groupId) throws Exception;
}
