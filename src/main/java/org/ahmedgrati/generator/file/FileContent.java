package org.ahmedgrati.generator.file;

import org.ahmedgrati.generator.schematics.Resource;
import org.ahmedgrati.generator.utils.generics.TriConsumer;
import org.apache.commons.io.IOUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class FileContent {

    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(FileContent.class.getName());

    private FileContent() {
    }

    /**
     * returns the decoded content of a file.
     */
    private static final Function<Resource, String> DECODED_SAMPLE_FILE_CONTENT = resource -> {
        InputStream inputStream = FileContent.class.getClassLoader().getResourceAsStream("samples/" +
                resource.getClass().getSimpleName() + ".txt");
        StringWriter writer = new StringWriter();
        String encoding = StandardCharsets.UTF_8.name();
        try {
            assert inputStream != null;
            IOUtils.copy(inputStream, writer, encoding);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "ERROR");
        }

        return writer.toString();


    };

    /**
     * @return FUNCTION
     */
    public static Function<Resource, String> getDecodedSampleFileContent() {
        return DECODED_SAMPLE_FILE_CONTENT;
    }


    /**
     * @return TriConsumer
     */
    public static TriConsumer<String, String, Resource> getFillFileWithContent() {
        return FILL_FILE_WITH_CONTENT;
    }


    /**
     * Fill a specific file with a content.
     */
    private static final TriConsumer<String, String, Resource> FILL_FILE_WITH_CONTENT = (path, resourceName, resource)
            -> {
        String fileContent = DECODED_SAMPLE_FILE_CONTENT.apply(resource);
        FileWriter fileWriter = new FileWriter(path);
        try (PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.printf(fileContent, resourceName);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "ERROR");
        }


    };
}
