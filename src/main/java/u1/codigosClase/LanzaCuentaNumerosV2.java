package u1.codigosClase;

import java.io.*;

public class LanzaCuentaNumerosV2 {
    public static void main(String[] args) {
        //Este programa lanza el programa compilado CuentaNumerosV2
        String[] proceso = {"java", "-jar", "./out/artifacts/PSPU1_jar2/PSPU1.jar"};
        ProcessBuilder pb = new ProcessBuilder(proceso);
        try {
            Process p = pb.start();
            //p.waitFor(5, TimeUnit.SECONDS); //Espera bloqueante para siempre

            //Redirecciono entrada (cojo la salida del subproceso)
            InputStream is = p.getInputStream();
            InputStreamReader isr =  new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            //Redirecciono salida (cojo la entrada del subproceso)
            OutputStream os = p.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            PrintWriter pw = new PrintWriter(osw);

            //1. Leo del subproceso
            String linea = br.readLine();
            System.out.println(linea);

            //2. Escribo hacia el subproceso
            pw.println("22");
            pw.flush();

            //3. Leo
            System.out.println(br.readLine());

            //4. Leo
            System.out.println(br.readLine());

            System.out.println("FIN");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
