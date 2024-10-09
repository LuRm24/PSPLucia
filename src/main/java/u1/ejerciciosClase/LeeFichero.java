package u1.ejerciciosClase;

import java.io.*;

public class LeeFichero {
    public static void main(String[] args){

        //Comprobar que el numero de argumentos de ejecución es correcto
        if (args.length == 1) {
            //Creo un objeto de tipo File para poder comprobar si existe y si es una carpeta
            File fichero = new File(args[0]);

            //Si el fichero no existe o es una carpeta
            if (!fichero.exists() || fichero.isDirectory()){
                System.out.println("El fichero no existe o es una carpeta");
            }
            else {
                try (FileReader fr = new FileReader(fichero.getPath());
                     BufferedReader br = new BufferedReader(fr);) {

                    //Leer el fichero linea a linea
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        System.out.println(linea);
                    }
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        else {
            System.out.println("No se ha indicado el nombre del fichero en los argumentos del main");
        }
    }
}
