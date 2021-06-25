package file;

import org.apache.commons.io.IOUtils;
import schematics.Resource;
import utils.generics.TriConsumer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;
import java.util.function.Function;

public class FileContent {

    public static Function<Resource, String> getDecodedSampleFileContent = resource -> {
        InputStream inputStream = FileContent.class.getClassLoader().getResourceAsStream("samples/" + resource.getClass().getSimpleName() + ".txt");
        StringWriter writer = new StringWriter();
        String encoding = StandardCharsets.UTF_8.name();
        try {
            IOUtils.copy(inputStream, writer, encoding);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return writer.toString();


    };

    public static TriConsumer<String, String, Resource> fillFIleWithContent = (path, resourceName, resource) -> {
        String fileContent = getDecodedSampleFileContent.apply(resource);
        FileWriter fileWriter = new FileWriter(path);
        try (PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.printf(fileContent, resourceName);
        }catch (Exception e) {
            e.printStackTrace();
        }


    };
}
