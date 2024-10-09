package u1.codigosClase;

import java.io.IOException;

import static java.util.concurrent.TimeUnit.SECONDS;

public class RecogeCodigosTerminacion {
    public static void main(String[] args) {
        String[] argumentos = {"gedit"};
        ProcessBuilder pb = new ProcessBuilder(argumentos);
        try {
            Process p = pb.start();
            //pb.waitFor(100, SECONDS);//espera máxima
            int codigo = p.waitFor();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch(Exception e){

        }
        System.out.println("Termina");
    }
}

