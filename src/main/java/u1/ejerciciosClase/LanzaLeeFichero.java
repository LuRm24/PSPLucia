package u1.ejerciciosClase;

import java.util.Scanner;

public class LanzaLeeFichero {
    public static void main(String[] args) {
        //Este programa lanza el programa LeeFichero (nos hemos creado un ejecutable / artefacto)
        // y es LeeFichero el que lee del fichero, LanzaLeeFichero solo redirecciona E/S.

        System.out.print("Qué fichero quieres leer: ");
        Scanner sc = new Scanner(System.in);
        String f = sc.nextLine();

        //Ejecutar LeeFichero (debe ser un artefacto compilado) con el argumento de ejecución y redireccionar las E/S que necesitemos
        // Aquí no se puede usar ni File, ni FileReader.



    }
}
