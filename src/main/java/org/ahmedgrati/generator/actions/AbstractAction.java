package org.ahmedgrati.generator.actions;


import org.ahmedgrati.generator.utils.ResourceParameter;

public interface AbstractAction {

    /**
     * @param resource
     * @param resourceName
     * @param groupId
     * @throws Exception
     */
    void execute(ResourceParameter resource, String resourceName, String groupId) throws Exception;
}
