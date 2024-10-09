package u1.ejerciciosClase;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Ejecutador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String programa = "";

        while (!programa.equals("ESC")) {
            System.out.println("Introduce el nombre del programa a ejecutar: ");
            //Introducimos la ruta completa del programa a ejecutar
            programa = sc.nextLine();

            try {
                //Si el programa a ejecutar es distinto de ESC
                if (!programa.equals("ESC")) {
                    //Creamos un nuevo proceso con la ruta completa del programa a ejecutar
                    ProcessBuilder proceso = new ProcessBuilder(programa);

                    //Ejecutamos el process builder como proceso
                    Process process = proceso.inheritIO().start();
                    ProcessHandle.Info informacion = process.info();

                    System.out.println("PID: " + process.pid());
                    System.out.println("Usuario: " + informacion.user());

                    process.waitFor(10, TimeUnit.SECONDS);
                }
                //process.destroy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
