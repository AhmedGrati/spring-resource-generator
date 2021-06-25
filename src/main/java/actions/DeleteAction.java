package actions;

import schematics.Resource;

import java.io.IOException;
import java.net.UnknownServiceException;

public class DeleteAction implements AbstractAction{
    @Override
    public void execute(Resource resource, String resourceName) throws IOException {
        throw new UnknownServiceException("This Method Is Not Implemented Yet");

    }
}
