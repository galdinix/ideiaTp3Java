package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import  com.google.*;

public class Main {
    public static void main(String[] args) {
        try {
            String apirUrl = "https://openweathermap.org/city/3451189" + "409cb50b18bd86d7170fe1e66071bad1";
            URL url = new URL(apirUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == 200){
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = reader.readLine()) != null){
                    response.append(inputLine);
                }
                reader.close();
                System.out.println(response.toString());
                Json 



            }else {
                System.out.println("ERRo na requisição" + responseCode);
            }
            connection.disconnect();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}