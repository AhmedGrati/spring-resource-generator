package file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileGeneration {

    private static final Logger logger = Logger.getLogger(FileGeneration.class.getName());

    private FileGeneration() {}

    private static final BiFunction<File, String, Boolean> createDirectory = (file, packageName) ->
            FileUtils.getFile(String.valueOf(Paths.get(file.getPath(), packageName))).mkdir();

    public static BiFunction<File, String, Boolean> getCreateDirectory() {
        return createDirectory;
    }

    public static Function<File, Boolean> getAddFile() {
        return addFile;
    }

    private static final Function<File, Boolean> addFile = file -> {
        try {
            return file.createNewFile();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "ERROR");
        }
        return null;
    };


}
