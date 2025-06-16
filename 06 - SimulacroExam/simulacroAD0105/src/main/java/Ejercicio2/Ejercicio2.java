package Ejercicio2;

import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Ejercicio2 {
    public static void main(String[] args) {
        try {
        URL url=new URL("https://dummyjson.com/products");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        BufferedReader bf=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        JSONObject response= new JSONObject(bf.readLine());
            JSONArray products = response.getJSONArray("products");

            for (int i = 0; i < products.length(); i++) {
                JSONObject product= (JSONObject) products.get(i);
                String name= product.getString("title");
                double price= product.getDouble("price");
                System.out.printf("%d:Nombre:  %s || Precio: %.2f \n",i,name, price);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
