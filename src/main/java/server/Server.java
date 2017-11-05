package server;

import server.data.parser.DOMXmlWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        System.out.println("Server running...");

        BufferedReader in;
        PrintWriter out;

        ServerSocket servers = null;
        Socket fromClient = null;

        try {
            servers = new ServerSocket(4444);
        } catch (IOException e) {
            System.out.println("Couldn't listen to port 4444");
            System.exit(-1);
        }

        try {
            System.out.print("Waiting for a client...");
            fromClient = servers.accept();
            System.out.println("Client connected");
        } catch (IOException e) {
            System.out.println("Can't accept");
            System.exit(-1);
        }

        in  = new BufferedReader(new
                InputStreamReader(fromClient.getInputStream()));
        out = new PrintWriter(fromClient.getOutputStream(),true);

        String input;

        System.out.println("Wait for messages");

        while ((input = in.readLine()) != null) {
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            out.println("S ::: " + input);

            DOMXmlWriter.write();

            System.out.println(input);
        }
        out.close();
        in.close();
        fromClient.close();
        servers.close();
    }
}