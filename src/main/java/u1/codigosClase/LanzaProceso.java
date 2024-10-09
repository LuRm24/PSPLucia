package u1.codigosClase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LanzaProceso {
    public static void main(String[] args) {
        //ProcessBuilder: Inicia el proceso que quiero ejecutar. Es una clase de java.
        ProcessBuilder pb= new ProcessBuilder("gedit","a.txt");//si intentas ejecutar un proceso que no existe salta la excepcion.
        try {
            Process p = pb.start();
            System.out.println(p.pid());//te dice el numero unico del proceso
            p.waitFor(5, TimeUnit.SECONDS); //espera indefinidamente hasta que el proceso termine y
            // puede lanzar una excepcion.Tambien puedes indicar
            //el tiempo que quieras
            if (!p.isAlive()){ //si el proceso esta muerto...
                System.out.println("El gedit murió");
            }else{
                System.out.println("El gedit está vivo");
            }
            p.destroy();

        }catch (IOException e){
            System.out.println("Error en el start: " + e.getMessage());
        }catch (InterruptedException e){
            System.out.println("Error en el waitfor: " + e.getMessage());

        }

        //Runtime: alternativa al ProcessBuilder
        Runtime rt = Runtime.getRuntime();
        try {
            Process p = rt.exec("gedit");
            //Con process puedo hacer lo mismo que antes
        }catch (IOException e){
            throw  new RuntimeException(e);
        }

    }
}
