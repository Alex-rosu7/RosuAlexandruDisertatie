package com.rosualexandru.disertatie.Services;

import com.rosualexandru.disertatie.Config.SecurityConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.URISyntaxException;
import java.net.URL;

public class Utils {
    private static final Logger log = LoggerFactory.getLogger(Utils.class);

    /**
     * Returns the absolute path of a given folder.
     * If the folder exists in src/main/resources, it retrieves the path dynamically.
     *
     * @param folderName The name of the folder (e.g., "config").
     * @return The absolute path of the folder.
     */
    public static String getFolderPath(String folderName) {
        folderName = folderName.toLowerCase();

        String relativePath = switch (folderName) {
            case "config" -> Constants.CONFIG_DIRECTORY;
            case "controllers" -> Constants.CONTROLLERS_DIRECTORY;
            case "exceptions" -> Constants.EXCEPTIONS_DIRECTORY;
            case "model" -> Constants.MODEL_DIRECTORY;
            case "repository" -> Constants.REPOSITORY_DIRECTORY;
            case "services" -> Constants.SERVICE_DIRECTORY;
            default -> Constants.DEFAULT_DIRECTORY;
        };

        URL resourceUrl = SecurityConfig.class.getClassLoader().getResource(folderName);
        if (resourceUrl != null) {
            try {
                return Paths.get(resourceUrl.toURI()).toString();
            } catch (URISyntaxException e) {
                log.error(e.getMessage());
            }
        }

        Path folderPath = Paths.get(folderName).toAbsolutePath();
        return folderPath.toString();
    }

    public static void createDirectory(String targetDirectory) {
        File directory = new File(Utils.getFolderPath(targetDirectory));
        if (!directory.exists()) {
            boolean created = directory.mkdirs();
            if (created) {
                log.debug("Created  directory: " + Utils.getFolderPath(targetDirectory));
            }
        }
    }
}
