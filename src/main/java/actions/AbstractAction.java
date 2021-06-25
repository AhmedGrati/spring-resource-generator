package actions;

import schematics.Resource;


public interface AbstractAction {

    void execute(Resource resource, String resourceName) throws Exception;
}
