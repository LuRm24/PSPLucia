package u1.ejerciciosClase;

public class Calculadora {
    public static void main(String[] args) {

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
