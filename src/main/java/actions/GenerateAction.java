package actions;

import file.FileContent;
import file.FileGeneration;
import file.FilePath;
import org.apache.commons.io.FileUtils;
import org.codehaus.plexus.util.StringUtils;
import schematics.Resource;
import utils.APITypeValues;
import utils.NamingUtils;

import java.io.*;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenerateAction implements AbstractAction {

    private static final Logger logger = Logger.getLogger(GenerateAction.class.getName());

    @Override
    public void execute(Resource resource, String resourceName) throws Exception {
        String appropriateResourceName = StringUtils.capitalise(resourceName);
        String fileName = appropriateResourceName + ".java";
        String packageName = NamingUtils.getPackageNameFromResourceAndAPIType(resource, APITypeValues.REST);
        File file = FileUtils.getFile("src/main/java");
        String path = FilePath.getGetPathOfResourcePackage().apply(file, packageName);
        if (path == null) {
            boolean isDirectoryCreated = FileGeneration.getCreateDirectory().apply(file, packageName);
            if (!isDirectoryCreated) {
               logger.log(Level.SEVERE, "ERROR");
            } else {
                String createdFilePath = String.valueOf(Paths.get(file.getPath(), packageName, fileName));

                boolean isFileCreated = FileGeneration.getAddFile().apply(new File(createdFilePath));
                if (isFileCreated) {
                    FileContent.getFillFileWithContent().accept(createdFilePath, appropriateResourceName, resource);
                } else {
                    logger.log(Level.SEVERE, "ERROR");
                }
            }
        }

    }


}
