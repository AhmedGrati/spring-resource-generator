package org.ahmedgrati.generator.file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class FileGeneration {

    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(FileGeneration.class.getName());

    private FileGeneration() {
    }

    /**
     * A BiFunction which creates a directory.
     */
    private static final BiFunction<File, String, Boolean> CREATE_DIRECTORY = (file, packageName) ->
            FileUtils.getFile(String.valueOf(Paths.get(file.getPath(), packageName))).mkdir();

    /**
     * @return BiFunction
     */
    public static BiFunction<File, String, Boolean> getCreateDirectory() {
        return CREATE_DIRECTORY;
    }

    /**
     * @return Function
     */
    public static Function<File, Boolean> getAddFile() {
        return ADD_FILE;
    }

    /**
     * A Function which creates a new file.
     */
    private static final Function<File, Boolean> ADD_FILE = file -> {
        try {
            return file.createNewFile();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "ERROR");
        }
        return null;
    };


}
