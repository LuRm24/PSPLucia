package u1.ejerciciosClase;

import ejercicio1.LeeFichero;

import java.io.IOException;

public class LanzaLeeFichero {
    public static void main(String[] args) {

        try {
            //Creamos un nuevo proceso con la ruta completa del programa a ejecutar
            ProcessBuilder proceso = new ProcessBuilder();
            proceso.command("./out/production/Procesos/ejercicio1/", "LeeFichero", "./files/ficheroEj1.txt");
            //Ejecutamos el process builder como proceso
            Process process = proceso.inheritIO().start();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
