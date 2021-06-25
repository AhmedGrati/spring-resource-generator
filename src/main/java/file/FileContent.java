package file;

import actions.GenerateAction;
import org.apache.commons.io.IOUtils;
import schematics.Resource;
import utils.generics.TriConsumer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileContent {

    private static final Logger logger = Logger.getLogger(FileContent.class.getName());
    private FileContent() {}

   private static final Function<Resource, String> decodedSampleFileContent = resource -> {
        InputStream inputStream = FileContent.class.getClassLoader().getResourceAsStream("samples/" + resource.getClass().getSimpleName() + ".txt");
        StringWriter writer = new StringWriter();
        String encoding = StandardCharsets.UTF_8.name();
        try {
            assert inputStream != null;
            IOUtils.copy(inputStream, writer, encoding);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "ERROR");
        }

        return writer.toString();


    };

    public static Function<Resource, String> getDecodedSampleFileContent() {
        return decodedSampleFileContent;
    }


    public static TriConsumer<String, String, Resource> getFillFileWithContent() {
        return fillFileWithContent;
    }


    private static final TriConsumer<String, String, Resource> fillFileWithContent = (path, resourceName, resource) -> {
        String fileContent = decodedSampleFileContent.apply(resource);
        FileWriter fileWriter = new FileWriter(path);
        try (PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.printf(fileContent, resourceName);
        }catch (Exception e) {
            logger.log(Level.SEVERE, "ERROR");
        }


    };
}
