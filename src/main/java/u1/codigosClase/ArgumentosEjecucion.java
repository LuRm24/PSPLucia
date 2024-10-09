package u1.codigosClase;

public class ArgumentosEjecucion {
    public static void main(String[] args) {
        //En este programa voy a jugar con los argumentos de ejecución(args)

        System.out.println(args.length);
        for(String a : args){
            System.out.println("...." +a);
        }
    }
}
