package com.practice.SocketProgramming.OneWay;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientSide {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost",5000);

        System.out.println("Client Connected at server Handshaking port " + socket.getPort());
        System.out.println("Client’s communication port " + socket.getLocalPort());
        System.out.println("Client is Connected");
        System.out.println("Enter the messages that you want to send and send \"stop\" to close the connection:");

        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String message = "";

        while (!message.equalsIgnoreCase("stop")){

            message = reader.readLine();
            outputStream.writeUTF(message);

        }
        outputStream.close();
        reader.close();
        socket.close();
    }
}
