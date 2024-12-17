package com.practice.SocketProgramming.TwoWay;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSide {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(5000);

        System.out.println("Server is connected at port no: " + serverSocket.getLocalPort());
        System.out.println("Server is connecting\n");
        System.out.println("Waiting for the client\n");

        Socket socket = serverSocket.accept();

        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));

        String clientMessage="";
        String serverMessage;

        while (!clientMessage.equalsIgnoreCase("stop")){

            clientMessage = inputStream.readUTF();
            System.out.println("Client says: " +clientMessage );

            System.out.println("Enter your reply: ");

            serverMessage = serverInput.readLine();
            outputStream.writeUTF(serverMessage);
            outputStream.flush();

        }
        socket.close();
        inputStream.close();
        outputStream.close();
        serverSocket.close();

    }
}
