package u1.ejerciciosClase;

public class Calculadora {
    public static void main(String[] args) {
      /*  Crea el programa Calculadora. Recibirá tres argumentos de ejecución:

        El primer operando (un número double)
        El segundo operando (un número double)
        El operador (un char que puede ser +, -, *, / o % dependiendo de la operación).

        En caso de que no se respete el número de argumentos o que su formato esté mal, se imprime un mensaje de error informando qué ha sucedido.

                Si todo funciona bien, mostrar por pantalla el resultado de la operación.

                Por ejemplo, si se ejecuta java -jar Calculadora.jar 3.4 5.7 +, el resultado será 9.1.*/
        //Si el numero de argumentos es correcto
        if (args.length == 3){

            try {
                //Intentar convertir los dos primeros argumentos de String a double
                double num1 = Double.parseDouble(args[0]);
                double num2 = Double.parseDouble(args[1]);
                String operacion = args[2];

                //Dependiendo de la operacion
                switch (operacion){
                    case "+":
                        System.out.println(num1 + num2);
                        break;
                    case "-":
                        System.out.println(num1 - num2);
                        break;
                    case "*":
                        System.out.println(num1 * num2);
                        break;
                    case "/":
                        System.out.println(num1 / num2);
                        break;
                    case "%":
                        System.out.println(num1 % num2);
                        break;
                    default:
                        System.out.println("Símbolo de la operación incorrecto");
                }

            }
            catch (NumberFormatException e) {
                //si introduces mal los argumentos de los numeros se produce una excepcion
                System.out.println("Formato de numero incorrecto");
            }
        }
        else {
            System.out.println("El numero de argumentos es incorrecto");
        }
    }
}
