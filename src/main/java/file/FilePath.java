package file;

import java.io.File;
import java.util.Objects;
import java.util.function.BiFunction;

public class FilePath {

    private FilePath() {}

    private static final BiFunction<File, String, String> findPathOfTheFileFromDirectory = (file, packageName) -> {
        for (File childFile : Objects.requireNonNull(file.listFiles())) {
            String path = FilePath.getPathOfResourcePackage.apply(childFile, packageName);
            if (path != null) {
                return path;
            }
        }
        return null;

    };

    public static BiFunction<File, String, String> getFindPathOfTheFileFromDirectory() {
        return findPathOfTheFileFromDirectory;
    }

    public static BiFunction<File, String, String> getGetPathOfResourcePackage() {
        return getPathOfResourcePackage;
    }

    private static final BiFunction<File, String, String> getPathOfResourcePackage = (file, packageName) -> {
        if (file != null && file.isDirectory()) {
            if (file.getName().equalsIgnoreCase(packageName)) {
                return file.getPath();
            }
            if (Objects.requireNonNull(file.listFiles()).length > 0) {
                findPathOfTheFileFromDirectory.apply(file, packageName);
            }
        }
        return null;

    };
}
