package actions;

import schematics.Resource;


public interface AbstractAction {

    /**
     * @param resource
     * @param resourceName
     * @throws Exception
     */
    void execute(Resource resource, String resourceName) throws Exception;
}
