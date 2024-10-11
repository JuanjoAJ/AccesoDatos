import controller.GestionFicheros;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        GestionFicheros gestionFicheros=new GestionFicheros();
        File file=new File("src/resources/FileMain");
        gestionFicheros.listFile(file, 0);



    }
}
