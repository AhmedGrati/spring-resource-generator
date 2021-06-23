package actions;

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

public class GenerateAction {


    public void generate(Resource resource, String resourceName) throws IOException {
        String appropriateResourceName = StringUtils.capitalise(resourceName);
        String fileName = appropriateResourceName+".java";
        String packageName = NamingUtils.getPackageNameFromResourceAndAPIType(resource, APITypeValues.REST);
        File file = FileUtils.getFile("src/main/java");
        String path = getPathOfResourcePackage(file, packageName);
        if (path == null) {
            boolean isDirectoryCreated = createDirectory(file, packageName);
            if (!isDirectoryCreated) {
                System.out.println("hey");
                // TODO: Implement Error Handling
            } else {
                String createdFilePath = String.valueOf(Paths.get(file.getPath(), packageName, fileName));
                boolean isFileCreated = addFile(new File(createdFilePath));
                if (isFileCreated) {
                    fillFileWithContent(createdFilePath, appropriateResourceName, resource);
                } else {
                    System.out.println("z");
                }
            }
        }
    }

    public String getDecodedSampleFileContent(Resource resource) throws IOException {

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("samples/" + resource.getClass().getSimpleName() + ".txt");
        StringWriter writer = new StringWriter();
        String encoding = StandardCharsets.UTF_8.name();
        IOUtils.copy(inputStream, writer, encoding);

        return writer.toString();

    }

    public void fillFileWithContent(String path, String resourceName, Resource resource) throws IOException {

        String fileContent = getDecodedSampleFileContent(resource);
        FileWriter fileWriter = new FileWriter(path);
        try (PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.printf(fileContent, resourceName);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean createDirectory(File file, String packageName) {

        System.out.println(file.getPath());
        return FileUtils.getFile(String.valueOf(Paths.get(file.getPath(), packageName))).mkdir();

    }


    public boolean addFile(File file) throws IOException {
        return file.createNewFile();

    }

    public String getPathOfResourcePackage(File file, String packageName) {
        if (file != null && file.isDirectory()) {
            if (file.getName().equalsIgnoreCase(packageName)) {
                return file.getPath();
            }
            if (Objects.requireNonNull(file.listFiles()).length > 0) {
                return findPathOfTheFileFromDirectory(file, packageName);
            }
        }
        return null;
    }

    public String findPathOfTheFileFromDirectory(File file, String packageName) {

        for (File childFile : Objects.requireNonNull(file.listFiles())) {
            String path = getPathOfResourcePackage(childFile, packageName);
            if (path != null) {
                return path;
            }
        }
        return null;
    }
}
