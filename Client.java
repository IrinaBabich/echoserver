package com.babich.echoserver.readerwriter;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Scanner in = new Scanner(System.in);
             Socket client = new Socket("localhost", 3001);
             BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))) {

            String message = in.nextLine();

            writer.write(message);
            writer.newLine();
            writer.flush();

            String line = reader.readLine();
            System.out.println(line);
        }
    }
}
