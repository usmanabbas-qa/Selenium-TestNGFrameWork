package Config; // IMPORTANT: Ensure this package name matches your setup (e.g., Project_Config)

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigReader class is responsible for loading properties from a configuration file.
 * This helps in managing test environment configurations (like base URL, browser type)
 * separately from the code, making the framework flexible and easy to update.
 */
public class ConfigReader {

    // Properties object to hold key-value pairs from the config file
    private static Properties properties;
    // Path to the configuration file
    private static final String CONFIG_FILE_PATH = "src/main/resources/config.properties";

    /**
     * Private constructor to prevent instantiation of this utility class.
     * This class is designed to be used with static methods only.
     */
    private ConfigReader() {
        // No instantiation
    }

    /**
     * Loads the properties from the configuration file.
     * This method is synchronized to ensure thread safety if multiple threads
     * try to load the config simultaneously (though typically loaded once).
     */
    public static synchronized void loadProperties() {
        // Check if properties are already loaded to avoid re-loading
        if (properties == null) {
            properties = new Properties();
            try (FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH)) {
                // Load properties from the input stream
                properties.load(fis);
            } catch (IOException e) {
                // Print stack trace if an error occurs during file reading
                System.err.println("Error loading configuration properties: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    /**
     * Retrieves a property value by its key.
     *
     * @param key The key of the property to retrieve.
     * @return The value of the property, or null if the key is not found.
     */
    public static String getProperty(String key) {
        // Ensure properties are loaded before attempting to retrieve a value
        if (properties == null) {
            loadProperties(); // Load properties if not already loaded
        }
        return properties.getProperty(key);
    }
}
