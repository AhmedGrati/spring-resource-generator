package org.ahmedgrati.generator.actions;


import org.ahmedgrati.generator.file.FileContent;
import org.ahmedgrati.generator.file.FileGeneration;
import org.ahmedgrati.generator.file.FilePath;
import org.ahmedgrati.generator.parameters.GenerateParameter;
import org.ahmedgrati.generator.schematics.*;
import org.ahmedgrati.generator.utils.APITypeValues;
import org.ahmedgrati.generator.utils.NamingUtils;
import org.ahmedgrati.generator.parameters.BaseParameter;
import org.ahmedgrati.generator.utils.ResourceParameter;
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
     * @param resourceParam
     * @param resourceName
     * @throws Exception
     */
    @Override
    public void execute(final ResourceParameter resourceParam, final String resourceName, final String groupId)
            throws Exception {
        Resource resource = null;
        switch (resourceParam.value()) {
            case "entity":
                resource = new Entity(new RESTApi());
                break;
            case "service":
                resource = new Service(new RESTApi());
                break;
            case "repository":
                resource = new Repository(new RESTApi());
                break;
            default:
                LOGGER.log(Level.SEVERE, "RESOURCE NOT FOUND");
        }
        String appropriateResourceName = StringUtils.capitalise(resourceName);

        String fileName = appropriateResourceName + ".java";

        String packageName = NamingUtils.getPackageNameFromResourceAndAPIType(resource, APITypeValues.REST);

        String directoryAsGroupID = groupId.replaceAll("\\.","/");
        File file = FileUtils.getFile("src/main/java/"+directoryAsGroupID);

        String path = FilePath.getGetPathOfResourcePackage().apply(file, packageName);

        if (path == null) {
            FileGeneration.getCreateDirectory().apply(file, packageName);

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
