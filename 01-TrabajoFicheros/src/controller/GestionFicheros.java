package controller;

import java.io.File;


public class GestionFicheros {
    public void listFile(File file, int i) {

        if (file.isDirectory()) {
            for (File item:file.listFiles()){
                if(!item.isHidden() && item.isFile()){
                    System.out.println("\t".repeat(i) + item.getName() + " ");
                }
            }

            for (File item : file.listFiles()) {
                if (!item.isHidden()) {
                    if (item.isDirectory()) {
                        System.out.println("\t".repeat(i) + item.getName());
                        listFile(item, i+1);

                    }
                }

            }
        }

    }
}
