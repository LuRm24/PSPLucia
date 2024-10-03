package u1.codigosClase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LanzaProceso {
    public static void main(String[] args) {
        //ProcessBuilder: indica el proceso que quiero ejecutar
        String[] programa = {"gedit", "a.txt"};
        ProcessBuilder pb = new ProcessBuilder(programa);
        try {
            Process p = pb.start();
            System.out.println(p.pid());    //PID identificador único de proceso asignado por el SO
            System.out.println(p.info());
            p.waitFor(10, TimeUnit.SECONDS);    //Espera indefinidamente hasta que el proceso termine
            p.destroy();    //Mata el proceso
            if (!p.isAlive()){
                System.out.println("El gedit murió");
            } else {
                System.out.println("El gedit está en ejecución");
            }

        } catch (IOException e) {
            System.err.println("Error en el start: " + e.getMessage());
        } catch (InterruptedException e){
            System.err.println("Error en el waitFor: " + e.getMessage());
        }

        //Runtime: alternativa al ProcessBuilder
        Runtime rt = Runtime.getRuntime();
        try {
            Process p = rt.exec("gedit");
            //Con Process puedo hacer lo mismo que antes.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
