package actions;

import org.apache.commons.io.FileUtils;
import org.codehaus.plexus.util.StringUtils;
import schematics.Resource;
import utils.APITypeValues;
import utils.NamingUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

public class GenerateAction {


    public void generate(Resource resource, String resourceName) throws IOException {
        String appropriateResourceName = StringUtils.capitalise(resourceName)+".java";
        String packageName = NamingUtils.getPackageNameFromResourceAndAPIType(resource, APITypeValues.REST);
        File file = FileUtils.getFile("src/main/java");
        String path = getPathOfResourcePackage(file, packageName);
        if(path == null) {
            boolean isDirectoryCreated = createDirectory(file,packageName);
            if(!isDirectoryCreated) {
                System.out.println("hey");
                // TODO: Implement Error Handlin
            }else {
                addFile(new File(String.valueOf(Paths.get(file.getPath(), packageName, appropriateResourceName))));
            }
        }
    }

    public boolean createDirectory(File file, String packageName) {

        System.out.println(file.getPath());
        return FileUtils.getFile(String.valueOf(Paths.get(file.getPath(), packageName))).mkdir();

    }


    public void addFile(File file) throws IOException {
        file.createNewFile();

    }

    public String getPathOfResourcePackage(File file, String packageName) {
        if (file != null) {
            if (file.isDirectory()) {
                if (file.getName().equalsIgnoreCase(packageName)) {
                    return file.getPath();
                }
                if (Objects.requireNonNull(file.listFiles()).length > 0) {
                    for (File childFile : Objects.requireNonNull(file.listFiles())) {
                        String path = getPathOfResourcePackage(childFile, packageName);
                        if (path != null) {
                            return path;
                        }
                    }
                }
            }
        }
        return null;
    }
}
