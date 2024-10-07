package u1.ejerciciosClase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class LeeFichero {
    public static void main(String[] args) {
        /*
        Crea un programa llamado LeeFichero que reciba como argumento de ejecución el fichero (o el path al fichero)
        que se quiere leer.
        El programa debe comprobar que existe este argumento de ejecución, en caso contrario mostrará un mensaje
        diciendo cómo se debe ejecutar y terminará.
        Si el fichero no existe, o es una carpeta, mostrará un mensaje de error informativo.
        Si todo funciona bien, mostraremos por pantalla el contenido del fichero.
         */

        //ESTE NO TIENE PROCESSBUILDER NI PROCESS NI NADA.

        if (args.length != 1) {
            System.out.println("Necesita argumento de ejecución con el fichero a leer");
            System.exit(1);
        }

        String fichero = args[0];
        File f = new File(fichero);

        // Compruebo si es carpeta / fichero
        if (f.isDirectory()) {
            System.out.println("Es una carpeta");
            return;
        }
        if (!f.exists()) {
            System.out.println("El fichero no existe");
            return;
        }

        // Leo el file
        try (BufferedReader br = new BufferedReader(new FileReader(f));) {
            String linea = "";
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
