package u1.codigosClase;

public class RecogeCodigosTerminacion {
    public static void main(String[] args) {
        String[] argumentos = {"gedit"};
        ProcessBuilder pb = new ProcessBuilder(argumentos);
        try {
            Process p = pb.start();
            //p.waitFor(5, TimeUnit.SECONDS);
            int codigo = p.waitFor();

            System.out.println("Termina con codigo " + codigo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
