package file;

import java.io.File;
import java.util.Objects;
import java.util.function.BiFunction;

public final class FilePath {

    private FilePath() {
    }

    /**
     * A BiFunction which find the path of specific file from a given package name.
     */
    private static final BiFunction<File, String, String> FIND_PATH_OF_THE_FILE_FROM_DIRECTORY = (file, packageName) -> {
        for (File childFile : Objects.requireNonNull(file.listFiles())) {
            String path = FilePath.GET_PATH_OF_RESOURCE_PACKAGE.apply(childFile, packageName);
            if (path != null) {
                return path;
            }
        }
        return null;

    };

    /**
     * @return BiFunction
     */
    public static BiFunction<File, String, String> getFindPathOfTheFileFromDirectory() {
        return FIND_PATH_OF_THE_FILE_FROM_DIRECTORY;
    }


    /**
     * @return BiFunction
     */
    public static BiFunction<File, String, String> getGetPathOfResourcePackage() {
        return GET_PATH_OF_RESOURCE_PACKAGE;
    }

    /**
     * Given a resource package and a specific file, this BiFunction returns the path of the file in that package.
     */
    private static final BiFunction<File, String, String> GET_PATH_OF_RESOURCE_PACKAGE = (file, packageName) -> {
        if (file != null && file.isDirectory()) {
            if (file.getName().equalsIgnoreCase(packageName)) {
                return file.getPath();
            }
            if (Objects.requireNonNull(file.listFiles()).length > 0) {
                FIND_PATH_OF_THE_FILE_FROM_DIRECTORY.apply(file, packageName);
            }
        }
        return null;

    };
}
