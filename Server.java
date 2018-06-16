package com.babich.echoserver.inputoutput;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
        Socket socket = serverSocket.accept();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());

        byte[] message = new byte[100];
        int count = bufferedInputStream.read(message);
        bufferedOutputStream.write("echo:".getBytes());
        bufferedOutputStream.write(message);
    }
}


