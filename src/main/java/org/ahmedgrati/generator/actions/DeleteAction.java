package org.ahmedgrati.generator.actions;

import org.ahmedgrati.generator.utils.ResourceParameter;

import java.net.UnknownServiceException;

public class DeleteAction implements AbstractAction {
    /**
     * @param resource
     * @param resourceName
     * @throws Exception
     */
    @Override
    public void execute(final ResourceParameter resource, final String resourceName, final String groupId)
            throws Exception {
        throw new UnknownServiceException("This Method Is Not Implemented Yet");

    }
}
