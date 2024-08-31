# Maven-Project

DevOps tool project with a Java client and Go server that automates builds, manages dependencies, and integrates a custom plugin.

## Features

- **Structure**: The main maven project is organized with two modules: Java client and Go server.

- **Automated Build and Packaging**: By running `mvn package`, the system automatically builds and packages the code. For Java, this results in a JAR file, while the Go server is packaged into a binary using the `exec-maven-plugin`.

- **Automated Testing**: The project is configured to run unit tests across all modules using the `mvn test`.

- **Dependency Management**: All dependencies are centrally managed in the POM files, eliminating the need for manual version control.

- **Custom Plugin Development**: The project features the development of a custom Maven plugin, integrated into the Compile phase. This plugin includes a Mojo that receives a file name as a parameter and performs operations such as loading, executing, or writing to the file.
