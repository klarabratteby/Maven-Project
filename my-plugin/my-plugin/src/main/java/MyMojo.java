import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Mojo(name = "process-file")
public class MyMojo extends AbstractMojo {

    @Parameter(property = "file", defaultValue = "example.txt")
    private String fileName;

    public void execute() {
        getLog().info("Processing file: " + fileName);
        // Define the file path
        File file = new File(fileName);
        try {
            // Create the file if it doesn't exist
            if (!file.exists()) {
                file.createNewFile();
            }
            // Create a FileWriter object
            FileWriter writer = new FileWriter(file);
            // Write content to the file
            writer.write("Hello, Maven!");
            // Close the writer
            writer.close();
            getLog().info("Content written to file: " + fileName);
        } catch (IOException e) {
            // Handle IO Exception
            getLog().error("Error writing to file: " + fileName, e);
        }
    }
}