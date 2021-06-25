package actions;

import schematics.Resource;

import java.io.IOException;

public interface AbstractAction {

    void execute(Resource resource, String resourceName) throws IOException;
}
