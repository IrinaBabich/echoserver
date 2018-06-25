package com.babich.echoserver.readerwriter;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket server = new ServerSocket(3000);
            while (true) {
                Socket client = server.accept();
                EchoHandler handler = new EchoHandler(client);
                handler.start();
            }
        } catch (Exception e) {
            System.err.println("Exception caught: " + e);
        }
    }
}

    // класс Thread позволяет JVM запускать потоки одновременно
    class EchoHandler extends Thread {
        Socket client;

        EchoHandler(Socket client) {
            this.client = client;
        }

        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

                while (true) {
                    String message = reader.readLine();
                    System.out.println("Message from client: " + message);
                    writer.write("echo: " + message);
                    writer.newLine();
                }
            } catch (Exception e) {
                System.err.println("Exception caught: client disconnected.");

            } finally {
                try {
                    client.close();
                } catch (Exception e) {
                }
            }
        }
}
