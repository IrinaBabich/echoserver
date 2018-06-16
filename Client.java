package com.babich.echoserver.inputoutput;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Socket socket = new Socket("localhost", 3000);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());

        String message = bufferedReader.readLine();
        bufferedOutputStream.write(message.getBytes());
        bufferedOutputStream.flush();

        byte[] buffer = new byte[100];
        int count = bufferedInputStream.read(buffer);

        System.out.println(new String(buffer, 0, count));
    }
}
