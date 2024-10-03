package u1.codigosClase;

public class CalculadoraConArgs {
    // Funciona con argumentos de ejecución:
    //1. Primer operando
    //2. Segundo operando
    //3. Operación: suma, resta, mult, div

    //Ejemplo: java -jar CalculadoraConArgs.jar 7 9 suma      -> Imprime "16"
    //java -jar CalculadoraConArgs.jar

    //Este programa va a tener códigos de finalización :)   ---> System.exit
    //(Los códigos son los que quiera, tengo que documentar qué significa cada uno)
    // 0. Bien
    // 15. Si no tiene exactamente 3 argumentos de ejecución
    // 21. Si los dos primeros argumentos no son double
    // 38. Si no reconoce la operación
    // 49. Si divide entre 0 (la división es infinito / indetermindo)

    public static void main(String[] args) {
        //Control de errores:
        //Error1: que tenga el número adecuado de args:
        if (args.length != 3) {
            System.out.println("Error: ejecuta Calculadora [opearndo1] [opearndo2] [suma/resta/mult/div]");
            //return;
            System.exit(15);
        }

        //Error2: que el formato de los operandos no sean números decimales
        //ejemplo: java -jar CalculadoraConArgs.jar 5.4 z suma
        double op1 = 0, op2 = 0;
        try {
            op1 = Double.parseDouble(args[0]);
            op2 = Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Algún operando no es un double");
            //return;
            System.exit(21);
        }

        switch (args[2]) {
            case "suma":
                System.out.println(op1 + op2);
                break;
            case "resta":
                System.out.println(op1 - op2);
//                System.out.printf("%.2f", op1-op2);
                break;
            case "mult":
                System.out.println(op1 * op2);
                break;
            case "div":
                if (op2 == 0) {
                    System.exit(49);
                }
                System.out.println(op1 / op2);
                break;
            default:
                System.out.println("Error en la operación: suma / resta / mult / div");
                System.exit(38);
        }

    }

}
