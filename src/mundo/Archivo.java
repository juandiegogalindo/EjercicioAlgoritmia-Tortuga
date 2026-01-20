package mundo;

import java.io.*;
import java.util.ArrayList;

/**
 * Clase que se encarga de crear, llenar e imprimir nuestro tablero donde se
 * jugara
 *
 * @author Diego Betancur
 * @author Juan Pablo Coronado
 * @author Juan Diego Galindo
 * @author Sofia Torres
 */
public class Archivo {

    /**
     * Metodo inicial para guardar nuestros archvios generados
     *
     * @param nombreArchivo
     * @param contenido
     */
    public static void guardarArchivo(String nombreArchivo, ArrayList contenido) {
        String guardar = "";
        for (int i = 0; i < contenido.size(); i++) {
            guardar += contenido.get(i) + ",";
        }
        File archivo = new File("Archivos\\" + nombreArchivo + ".txt");
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            salida.println(guardar);
            salida.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
