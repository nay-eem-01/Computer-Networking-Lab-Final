package com.practice.GET_POST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;

public class PostMethod {
    public static void main(String[] args) throws IOException, URISyntaxException {

        URL myUrl = new URI("https://jsonplaceholder.typicode.com/posts/").toURL();

        HttpURLConnection connection = (HttpURLConnection) myUrl.openConnection();

        connection.setRequestMethod("POST");

        connection.setDoOutput(true);

        OutputStream out = connection.getOutputStream();

        String postedString = "Hi i am posting this string to web";

        out.write(postedString.getBytes());

        int responseCode = connection.getResponseCode();

        System.out.println("Value of HTTP_CREATED is " + HttpURLConnection.HTTP_CREATED);

        if (responseCode == HttpURLConnection.HTTP_CREATED){
            System.out.println("The connection is perfectly created");
            System.out.println("Response code form server: " + responseCode);
            System.out.println("Response message form server: " + connection.getResponseMessage());
        }
        else {
            System.out.println("Go home everybody");
        }

        InputStreamReader input = new InputStreamReader(connection.getInputStream());

        BufferedReader bufferedReader = new BufferedReader(input);

        StringBuilder stringBuilder = new StringBuilder();

        String eachLine;

        while ((eachLine = bufferedReader.readLine()) != null){
            stringBuilder.append(eachLine);
            stringBuilder.append(System.lineSeparator());
        }
        bufferedReader.close();

        System.out.println("Posted string fetching from web page : " + stringBuilder);
    }
}
