package Clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Factura {

    FileInputStream entrada;
    FileOutputStream salida;
    File archivo;

    public Factura() {
    }

    //Abrir archivo
    public String abrirArchivo(File f) {
        String contenido = "";
        try {

            entrada = new FileInputStream(f);
            int temp;
            while ((temp = entrada.read()) != -1) {
                char letra = (char) temp;
                contenido = contenido + letra;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return contenido;

    }

    //gusrdarlo 
    public String GuardarArchivo(File dir, String archivo) {
        String rta = "";
        try {
            salida = new FileOutputStream(dir); //flujo de bytes
            byte[] bitesdelarchivo = archivo.getBytes();
            salida.write(bitesdelarchivo);
            rta ="Guardado exitosamente"; 
        } catch (Exception e) {
             System.out.println(e);
        }
        return rta;
    }

}
