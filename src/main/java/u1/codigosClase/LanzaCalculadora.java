package u1.codigosClase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LanzaCalculadora {
    public static void main(String[] args) {
        /*
        Pide a la persona usuaria (Scanner System.in).
        1. Operación que quiere realizar
        2. Primer operando
        3. Segundo operando
        -------> NINGÚN CONTROL DE ERRORES. Usa solo Scanner.nextLine()

        Lanza Calculadora con los argumentos de ejecución
         */

        Scanner entrada = new Scanner(System.in);
        System.out.print("Operación: ");
        String operacion = entrada.nextLine();
        System.out.print("Primer operando: ");
        String num1 = entrada.nextLine();
        System.out.print("Segundo operando: ");
        String num2 = entrada.nextLine();

        String[] proceso = {"java", "-jar", "./out/artifacts/Calculadora/PSPU1.jar", num1, num2, operacion};
        ProcessBuilder pb = new ProcessBuilder(proceso);
        //pb.inheritIO();
        try {
            Process p = pb.start();
            //Redirecciono la entrada del subproceso
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String restultado = br.readLine();

            //Recojo el código de finalización:
            int codigo = p.waitFor();
            if (codigo == 0) {
                System.out.println(restultado);
            } else if (codigo == 15) {
                System.out.println("Error de argumentos: " + codigo);
            } else if (codigo == 21) {
                System.out.println("No son números: " + codigo);
            } else if (codigo == 38) {
                System.out.println("Operación no reconocida: " + codigo);
            } else if (codigo == 49) {
                System.out.println("División / 0: " + codigo);
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Waitfor: " + e.getMessage());
        }
    }
}


//EJERCICIO: Crea LanzaCalculadoraV2 modificando LanzaCalculadora
// para que te vuelva a pedir todos los argumentos hasta que el código de
// finalización sea 0 (es decir, hasta que se ejecute bien).