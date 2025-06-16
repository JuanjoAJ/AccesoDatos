package Ejercicio3;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Ejercicio3 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://randomuser.me/api/?results=50");
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            BufferedReader bf= new BufferedReader(new InputStreamReader(connection.getInputStream()));
            JSONObject response = new JSONObject(bf.readLine());
            JSONArray results = response.getJSONArray("results");
            for (int i = 0; i < results.length(); i++) {
                JSONObject user = (JSONObject) results.get(i);
                //: nombre, apellido, dirección, correo y teléfono
                JSONObject name = user.getJSONObject("name");
                String first = name.getString("first");
                String last = name.getString("last");
                JSONObject location = user.getJSONObject("location");
                JSONObject street = location.getJSONObject("street");
                String streetName = street.getString("name");
                int streetNumber = street.getInt("number");
                String city = location.getString("city");

                String direccion = streetName + " nº " + streetNumber + ", " + city;

                String email = user.getString("email");
                String phone = user.getString("phone");
                System.out.printf("%s %s vive en %s con email %s y telefono %s \n\n", first, last, direccion, email, phone);

            }



        } catch (MalformedURLException e) {
            System.out.println("El url está mal");
        } catch (IOException e) {
            System.out.println("Fallo en entrada salida");
        }
    }
}
