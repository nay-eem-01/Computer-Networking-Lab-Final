package com.practice.SocketProgramming.TwoWay;

import java.io.*;
import java.net.Socket;

public class ClientSide {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost",5000);

        System.out.println("Client Connected at server Handshaking port " + socket.getPort());
        System.out.println("Client’s communication port " + socket.getLocalPort());
        System.out.println("Client is Connected");
        System.out.println("Enter the messages that you want to send and send \"stop\" to close the connection:");

        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));

        String clientMessage = "";
        String serverMessage ;

        while (!clientMessage.equalsIgnoreCase("stop")){

            System.out.println("Type message: ");
            clientMessage = clientInput.readLine();
            outputStream.writeUTF(clientMessage);
            outputStream.flush();

            serverMessage = inputStream.readUTF();
            System.out.println("Server  says : " + serverMessage);

        }
        outputStream.close();
        clientInput.close();
        socket.close();
    }
}
