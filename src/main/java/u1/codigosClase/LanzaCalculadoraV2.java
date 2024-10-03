package u1.codigosClase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LanzaCalculadoraV2 {
    //EJERCICIO: Crea LanzaCalculadoraV2 modificando LanzaCalculadora
    // para que te vuelva a pedir todos los argumentos hasta que el código de
    // finalización sea 0 (es decir, hasta que se ejecute bien).
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int codigo = -1;
        while (codigo != 0) {
            System.out.print("Operación: ");
            String operacion = entrada.nextLine();
            System.out.print("Primer operando: ");
            String num1 = entrada.nextLine();
            System.out.print("Segundo operando: ");
            String num2 = entrada.nextLine();

            String[] proceso = {"java", "-jar", "./out/artifacts/Calculadora/PSPU1.jar", num1, num2, operacion};
            ProcessBuilder pb = new ProcessBuilder(proceso);

            try {
                Process p = pb.start();
                //Redirecciono la entrada del subproceso
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String restultado = br.readLine();

                //Recojo el código de finalización:
                codigo = p.waitFor();
                switch (codigo) {
                    case 0:
                        System.out.println(restultado);
                        break;
                    case 15:
                        System.out.println("Error de argumentos: " + codigo);
                        break;
                    case 21:
                        System.out.println("No son números: " + codigo);
                        break;
                    case 38:
                        System.out.println("Operación no reconocida: " + codigo);
                        break;
                    case 49:
                        System.out.println("División / 0: " + codigo);
                        break;
                }
                br.close();
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (InterruptedException e) {
                System.err.println("Waitfor: " + e.getMessage());
            }
        }
    }
}
