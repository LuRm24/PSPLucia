package u1.codigosClase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LanzaCalculadora2 {
    //EJERCICIO: Crea LanzaCalculadoraV2 modificando LanzaCalculadora
    // para que te vuelva a pedir todos los argumentos hasta que el código de
    // finalización sea 0 (es decir, hasta que se ejecute bien).
    public static void main(String[] args) {

        int codigo = -1;
        Scanner entrada = new Scanner(System.in);

        // Bucle que continuará hasta que el código de finalización sea 0
        while (codigo != 0) {
            System.out.println("Operación (sum, rest,mul, div): ");
            String operacion = entrada.nextLine();
            System.out.println("Primer operando: ");
            String num1 = entrada.nextLine();
            System.out.println("Segundo operando: ");
            String num2 = entrada.nextLine();

            // Proceso que invoca la calculadora externa
            String[] proceso = {"java", "-jar", "./out/artifacts/PSPUnidad1_jar3/PSPUnidad1.jar", num1, num2, operacion};
            ProcessBuilder pb = new ProcessBuilder(proceso);
            try {
                // Iniciamos el proceso
                Process p = pb.start();
                // Redirecciono la salida del subproceso
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

                // Recojo el código de finalización
                codigo = p.waitFor();

                // Si el proceso finaliza correctamente (código 0), mostramos el resultado
                switch (codigo) {
                    case 0:
                        // Leemos la salida del proceso (resultado de la operación)
                        String resultado = br.readLine();
                        System.out.println("El resultado recibido es: " + resultado);
                        break;
                    case 1:
                        // Error específico de código 1, probablemente mala operación
                        System.out.println("Error: Operación inválida o problema con los operandos.");
                        break;
                    default:
                        // Cualquier otro código de error
                        System.out.println("Error desconocido, código de finalización: " + codigo);
                }

            } catch (IOException e) {
                System.out.println("Error de E/S: " + e.getMessage());
            } catch (InterruptedException e) {
                System.out.println("Proceso interrumpido: " + e.getMessage());
            }
        }

        System.out.println("Operación finalizada con éxito.");
        entrada.close();
    }
}
