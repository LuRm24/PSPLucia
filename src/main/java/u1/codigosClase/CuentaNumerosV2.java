package u1.codigosClase;

import java.util.Scanner;

public class CuentaNumerosV2 {
    //Esto sería un programa complejo, me lo dan compilado y no puedo acceder al código
    // Solamente me dicen cómo interactuar con él:
    //1. Escribe instrucciones
    //2. Lee un número
    //3. Escribe los números
    //4. Escribe "FIN"

    public static void main(String[] args) {
        System.out.println("Hasta qué número: ");
        Scanner sc = new Scanner(System.in);
        int numero = Integer.parseInt(sc.nextLine());
        for (int i =0; i<=numero; i++){
            System.out.print(i + ", ");
        }
        System.out.println("\nFIN");
    }
}
