package actions;

import file.FileContent;
import file.FileGeneration;
import file.FilePath;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.codehaus.plexus.util.StringUtils;
import schematics.Resource;
import utils.APITypeValues;
import utils.NamingUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Objects;

public class GenerateAction implements AbstractAction {


    @Override
    public void execute(Resource resource, String resourceName) throws IOException {
        String appropriateResourceName = StringUtils.capitalise(resourceName);
        String fileName = appropriateResourceName+".java";
        String packageName = NamingUtils.getPackageNameFromResourceAndAPIType(resource, APITypeValues.REST);
        File file = FileUtils.getFile("src/main/java");
        String path = FilePath.getPathOfResourcePackage.apply(file, packageName);
        if (path == null) {
            boolean isDirectoryCreated = FileGeneration.createDirectory.apply(file, packageName);
            if (!isDirectoryCreated) {
                System.out.println("hey");
                // TODO: Implement Error Handling
            } else {
                String createdFilePath = String.valueOf(Paths.get(file.getPath(), packageName, fileName));

                boolean isFileCreated = FileGeneration.addFile.apply(new File(createdFilePath));
                if (isFileCreated) {
                    FileContent.fillFIleWithContent.accept(createdFilePath, appropriateResourceName, resource);
                } else {
                    System.out.println("z");
                }
            }
        }

    }


}
