package u1.ejerciciosClase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LanzaLeeFichero {
    public static void main(String[] args) {
        //Ejercicio 4 y 5

        // Pedimos al usuario que ingrese el nombre del fichero
        System.out.print("Introduce el nombre del fichero: ");
        Scanner scanner = new Scanner(System.in);
        String nombrearchivo = scanner.nextLine();

        String[] proceso ={"java", "-jar", "./out/artifacts/PSP_jar/PSP.jar",nombrearchivo};
        //Creamos un nuevo proceso con la ruta completa del programa a ejecutar
        ProcessBuilder pb = new ProcessBuilder(proceso);
        try {
            pb.inheritIO();
            //alternativa a Inherit
            Process p = pb.start();
//            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
//            String linea = "";
//            while((linea =br.readLine()) != null){
//                System.out.println(linea);
//            }
//            br.close();
            //pb.inheritIO();//para redireccionar los 3 strams del subproceso: in,out y err a la consola actual
            //si hacemos inherit no hacemos la redireccion de p.getInputStream y alreves lo mismo¨:
            //si hacemos p.getInputStream no hacemos Inherit
            //Ejecutamos el process

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
