package server;

import server.data.parser.DOMXmlModifier;
import server.data.parser.DOMXmlReader;
import server.data.parser.DOMXmlWriter;
import server.presentation.delegator.IDelegator;
import server.presentation.delegator.impl.greetinger.DelegatorImpl;
import server.presentation.view.IView;
import server.presentation.view.View;
import server.presentation.view.greetinger.GreetingView;

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

        IDelegator delegator = new DelegatorImpl(out);

        while ((input = in.readLine()) != null) {

            delegator.whatView(Integer.parseInt(input));

//            switch (input) {
//                case "1": {
//                    DOMXmlReader.reader();
//                    break;
//                }
//                case "2": {
//                    DOMXmlWriter.write();
//                    break;
//                }
//                case "3": {
//                    DOMXmlModifier.modify(1);
//                    break;
//                }
//                case "exit": {
//                    System.exit(1);
//                }
//            }

            System.out.println(input);

        }

        out.close();
        in.close();
        fromClient.close();
        servers.close();
    }
}
