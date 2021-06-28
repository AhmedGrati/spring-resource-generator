package actions;

import schematics.Resource;

import java.net.UnknownServiceException;

public class DeleteAction implements AbstractAction {
    /**
     * @param resource
     * @param resourceName
     * @throws Exception
     */
    @Override
    public void execute(final Resource resource, final String resourceName) throws Exception {
        throw new UnknownServiceException("This Method Is Not Implemented Yet");

    }
}
