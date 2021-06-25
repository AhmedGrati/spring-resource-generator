package file;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FileGeneration {

    public static BiFunction<File, String, Boolean> createDirectory = (file, packageName) -> {
        System.out.println(file.getPath());
        return FileUtils.getFile(String.valueOf(Paths.get(file.getPath(), packageName))).mkdir();

    };

    public static Function<File, Boolean> addFile = file -> {
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    };


}
