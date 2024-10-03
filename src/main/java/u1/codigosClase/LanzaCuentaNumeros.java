package u1.codigosClase;

import java.io.*;

public class LanzaCuentaNumeros {
    public static void main(String[] args) {
//        String proceso = "java -jar ./out/artifacts/PSPU1_jar/PSPU1.jar"; //ASÍ ESTÁ MAL
        String[] proceso = {"java", "-jar", "./out/artifacts/PSPU1_jar/PSPU1.jar"};
        ProcessBuilder pb = new ProcessBuilder(proceso);
        try {
            Process p = pb.start();
            InputStream is = p.getErrorStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            //Las tres líneas de antes se pueden hacer en una sola:
            //BufferedReader brPro = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String linea = "";
            while ((linea = br.readLine()) != null) {
                System.out.println("----- " + linea);
            }

            p.waitFor();
            System.out.println("LanzaCuentaNumeros termina");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
