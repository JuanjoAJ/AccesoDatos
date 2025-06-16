package Ejercicio1;

import java.io.*;

public class Ejercicio1 {
    public static void main(String[] args) {

        File file=new File("src/main/java/Ejercicio1/fichero.txt");

        try {
            BufferedReader bf= new BufferedReader(new FileReader(file));
            String linea;
            while ((linea = bf.readLine())!=null)
            {
                System.out.println(linea);
            }




        } catch (FileNotFoundException e) {
            System.out.println("Ande esta el archivo weon");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
