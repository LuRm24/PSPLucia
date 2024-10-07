package u1.ejerciciosClase;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Ejecutador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String comando = "";
        while (!comando.equals("ESC")) {
            try {
                System.out.print("Dime un programa que quieras ejecutar: ");
                comando = sc.nextLine();
                ProcessBuilder pb = new ProcessBuilder(comando);
                Process p = pb.start();
                p.waitFor(5, TimeUnit.SECONDS);
//                p.destroy(); En principio no deberíamos hacerlo.
            } catch (Exception e) {
                System.out.println("El programa no existe.");
            }
        }
    }
}
