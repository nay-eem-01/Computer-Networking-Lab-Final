package com.practice.SocketProgramming.OneWay;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSide  {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(5000);

        System.out.println("Server is connected at port no: " + serverSocket.getLocalPort());
        System.out.println("Server is connecting\n");
        System.out.println("Waiting for the client\n");

        Socket socket = serverSocket.accept();

        DataInputStream inputStream = new DataInputStream(socket.getInputStream());

        String message="";

        while (!message.equalsIgnoreCase("stop")){
            message = inputStream.readUTF();
            System.out.println("Client says: " + message);
        }
        socket.close();
        inputStream.close();

    }
}
