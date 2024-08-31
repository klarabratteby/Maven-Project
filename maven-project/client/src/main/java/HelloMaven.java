import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class HelloMaven {
    public static void main(String[] args) {
        final String host = "localhost";
        final int portNumber = 8080;

        try (Socket socket = new Socket(host, portNumber);
             OutputStream out = socket.getOutputStream();
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Send request to the server
            out.write("GET /list HTTP/1.1\r\n".getBytes());
            out.write("Host: localhost\r\n".getBytes());
            out.write("Connection: close\r\n".getBytes());
            out.write("\r\n".getBytes());
            out.flush();

            // Read response from the server
            String line;
            System.out.println("Response from Server:");
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + host);
        } catch (IOException e) {
            System.err.println("I/O Exception: " + e.getMessage());
        }
    }
}