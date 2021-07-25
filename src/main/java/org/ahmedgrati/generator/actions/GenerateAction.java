package org.ahmedgrati.generator.actions;


import org.ahmedgrati.generator.file.FileContent;
import org.ahmedgrati.generator.file.FileGeneration;
import org.ahmedgrati.generator.file.FilePath;
import org.ahmedgrati.generator.schematics.Resource;
import org.ahmedgrati.generator.utils.APITypeValues;
import org.ahmedgrati.generator.utils.NamingUtils;
import org.apache.commons.io.FileUtils;
import org.codehaus.plexus.util.StringUtils;


import java.io.File;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenerateAction implements AbstractAction {

    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(GenerateAction.class.getName());

    /**
     * @param resource
     * @param resourceName
     * @throws Exception
     */
    @Override
    public void execute(final Resource resource, final String resourceName) throws Exception {
        String appropriateResourceName = StringUtils.capitalise(resourceName);
        String fileName = appropriateResourceName + ".java";
        String packageName = NamingUtils.getPackageNameFromResourceAndAPIType(resource, APITypeValues.REST);
        File file = FileUtils.getFile("src/main/java");
        String path = FilePath.getGetPathOfResourcePackage().apply(file, packageName);
        if (path == null) {
            boolean isDirectoryCreated = FileGeneration.getCreateDirectory().apply(file, packageName);
            if (!isDirectoryCreated) {
                LOGGER.log(Level.SEVERE, "ERROR");
            } else {
                String createdFilePath = String.valueOf(Paths.get(file.getPath(), packageName, fileName));

                boolean isFileCreated = FileGeneration.getAddFile().apply(new File(createdFilePath));
                if (isFileCreated) {
                    FileContent.getFillFileWithContent().accept(createdFilePath, appropriateResourceName, resource);
                } else {
                    LOGGER.log(Level.SEVERE, "ERROR");
                }
            }
        }

    }


}
