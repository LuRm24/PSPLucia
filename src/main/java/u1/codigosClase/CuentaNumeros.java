package u1.codigosClase;

import java.util.Scanner;

public class CuentaNumeros {
    public static void main(String[] args) {
        System.out.println("Hasta que número: ");
        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt();
        for (int i = 0; i <= numero; i++) {
            System.out.println(i + ", ");
        }
        System.out.println("\nFIN");
    }

}
//Crear un programa que lance CuentaNumeros

