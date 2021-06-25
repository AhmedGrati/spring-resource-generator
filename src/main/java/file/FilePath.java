package file;

import java.io.File;
import java.util.Objects;
import java.util.function.BiFunction;

public class FilePath {

    public static BiFunction<File, String, String> findPathOfTheFileFromDirectory = (file, packageName) -> {
        for (File childFile : Objects.requireNonNull(file.listFiles())) {
            String path = FilePath.getPathOfResourcePackage.apply(childFile, packageName);
            if (path != null) {
                return path;
            }
        }
        return null;

    };

    public static BiFunction<File, String, String> getPathOfResourcePackage = (file, packageName) -> {
        if (file != null && file.isDirectory()) {
            if (file.getName().equalsIgnoreCase(packageName)) {
                return file.getPath();
            }
            if (Objects.requireNonNull(file.listFiles()).length > 0) {
                String path = findPathOfTheFileFromDirectory.apply(file, packageName);
            }
        }
        return null;

    };
}
