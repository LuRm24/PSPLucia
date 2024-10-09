package u1.codigosClase;

public class CalculadoraConArgs {
    //Funciona con argummentos de ejecucion
    //1.Primer operando
    //2.Segundo operando
    //3.Operacion : suma ,resta, mul,div

    //Ejemplo : java -jar CalculadoraConArgs.jar 7  9 suma  -->Imprime "16"
    //java -jar CalculadoraConArgs.jar

    //Este programa va a tener codigos de finalización
    //0. Bien
    //15.Si no tiene exactamente 3 argumentos de ejecución
    //21.Si los dos primeros argumento no son double
    //38.Si no reconoce la operación
    //49.Si divide entre 0 (la division es infinita/indeterminada)
    public static void main(String[] args) {
        //Control de errores:
        //Error1: que tenga el número adecuado de args
        if(args.length != 3){
            System.out.println("Error: ejecuta Calculadora [Operando1] [Operando2]  [sum,resta,mult,div]");
             //return;
            System.exit(15);
        }


        //Error2: que el formato de los operandos no sean numeros enteros
        //ejemplo: java -jar CalculadoraConArgs.jar
        double op1 = 0 , op2 = 0;
        try{
            op1 = Double.parseDouble(args[0]);
            op2 = Double.parseDouble(args[1]);
        }catch(NumberFormatException e){
            System.out.println("Algún operando es un double");
            //return;
            System.exit(21);
        }

        switch (args[2]) {
            case "suma":
                System.out.println(op1 + op2);
                break;

            case"rest":
                System.out.println(op1 - op2);
                break;

            case "mult":
                System.out.println(op1 * op2);
                break;
            case "div":
                //GEstionar que op2 no sea 0
                if(op2 == 0){
                    System.out.println("No puedes dividir entre 0");
                    System.exit(49);
                }
                System.out.println(op1 / op2);
                break;
            default:
                System.out.println("Error en el operando: suma / resta / mult / div");
                System.exit(38);
        }


    }
}
