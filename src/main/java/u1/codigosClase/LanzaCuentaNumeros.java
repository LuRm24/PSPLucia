package u1.codigosClase;

import java.io.*;

import java.util.concurrent.TimeUnit;


public class LanzaCuentaNumeros {
    public static void main(String[] args) {
        //Este programa lanza el programa compilado
        String[] proceso = {"java","-jar","./out/artifacts/PSPUnidad1_jar/PSPUnidad1.jar"};
        ProcessBuilder pb = new ProcessBuilder(proceso);

        try{
            Process p = pb.start();
            //p.waitFor(5, TimeUnit.SECONDS);//Espera bloqueante para siempre
            //Redireccionando entrada(cojo la salida del subproceso)
            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);


            //Redireccionando salida(cojo la entrada del subproceso)
           // OutputStream os = p.getOutputStream();
           // OutputStreamWriter osw = new OutputStreamWriter(os);
            //BufferedWriter bw = new BufferedWriter(osw);
            //PrintWriter pw = new PrintWriter(osw);

            //System.out.println("FIN");

            //Las tres lineas de antes se pueden hacer en una sola
            //BufferedReader Pro = new BufferedReader(new InputStreamReader(p.getInputStream()));

            //1.Leo el subproceso
            //String linea = br.readLine();
            //System.out.println(linea);

            //2.Escribo hacia el subproceso
            //pw.println("22");
            //pw.flush();
            //bw.write(sc.nextLine());
            //bw.newLine();
            //bw.flush();

            //3.Leo
            //System.out.println(br.readLine());

            //4.Leo
            //System.out.println(br.readLine());

            String linea = "";
            while((linea =br.readLine()) != null){
                System.out.println("-----" + linea);
            }
            p.waitFor();
            System.out.println("LanzaCuentaNumeros termina");
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();

        }
    }
}
