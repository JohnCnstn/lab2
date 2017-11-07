package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to Client side");

        Socket fromServer;

        System.out.println("Connecting to... " + "localhost");

        fromServer = new Socket("localhost",4444);

        BufferedReader in  = new
                BufferedReader(new
                InputStreamReader(fromServer.getInputStream()));

        PrintWriter out = new
                PrintWriter(fromServer.getOutputStream(),true);

        BufferedReader inu = new
                BufferedReader(new InputStreamReader(System.in));

        String fuser,fserver;

        int j;

        while (true) {
            j = Integer.parseInt(in.readLine());
            for (int i = 0; i < j; i++) {
                fserver = in.readLine();
                System.out.println(fserver);
            }
            fuser = inu.readLine();
            out.println(fuser);
            if (fuser.equalsIgnoreCase("exit")) break;
        }

        out.close();
        in.close();
        inu.close();
        fromServer.close();
    }
}
