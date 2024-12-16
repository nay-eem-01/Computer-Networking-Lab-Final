package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class GETMethod {
    public static void main(String[] args) throws URISyntaxException, IOException {

        URL myUrl = new URL("https://webcode.me/");

        HttpURLConnection connection = (HttpURLConnection) myUrl.openConnection();

        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        System.out.println("HTTP_GET method response code is : " + HttpURLConnection.HTTP_OK);

        InputStreamReader input = new InputStreamReader(connection.getInputStream());

        BufferedReader bufferedReader = new BufferedReader(input);

        StringBuilder stringBuilder = new StringBuilder();

        String content;

        if (responseCode == HttpURLConnection.HTTP_OK){
            System.out.println("The connection is successfully opened");
            System.out.println("Response code from server: " + responseCode);
            System.out.println("Response message from server: " + connection.getResponseMessage());

            while ((content = bufferedReader.readLine()) != null){
                stringBuilder.append(content);
                stringBuilder.append(System.lineSeparator());
            }

            bufferedReader.close();
        }
        else {
            System.out.println("Connection not established ");
        }

        System.out.println("Content from URL: \n\n" + stringBuilder);

    }
}
