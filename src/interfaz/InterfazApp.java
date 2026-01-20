package interfaz;

import java.util.Scanner;
import mundo.Tortuga;
import static mundo.Archivo.*;

/**
 * Clase que se encarga de crear, llenar e imprimir nuestro tablero donde se jugara
 * @author Diego Betancur
 * @author Juan Pablo Coronado
 * @author Juan Diego Galindo
 * @author Sofia Torres
 */
public class InterfazApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nombreArchivo;
        Scanner sc = new Scanner(System.in);
        int RespuestaLapiz = 0, opcion = 0;
        Tortuga tortuga = new Tortuga();
        tortuga.InicioMatriz();
        while (opcion != 4) {
            System.out.println("Archivo, que desea hacer?");
            System.out.println("1. Nuevo");
            System.out.println("2. Guardar");
            System.out.println("3. Cerrar y Finalizar Juego");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    while (true) {
                        System.out.println("1. Subir Lapiz");
                        System.out.println("2. Bajar lapiz");
                        System.out.println("3. Borrador");
                        System.out.println("4. Guardar y salir");
                        RespuestaLapiz = sc.nextInt();
                        if (RespuestaLapiz == 4) {
                            System.out.println("Escriba el nombre del archivo: ");
                            nombreArchivo = sc.next();
                            guardarArchivo(nombreArchivo, tortuga.getGuardado());
                            tortuga.vaciar();
                            break;
                        } else {
                            tortuga.getGuardado().add(RespuestaLapiz + "");
                            tortuga.OpcionesLapiz(RespuestaLapiz);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Escriba el nombre del archivo: ");
                    nombreArchivo = sc.next();
                    guardarArchivo(nombreArchivo, tortuga.getGuardado());
                    tortuga.vaciar();
                    break;
                case 3:
                    System.out.println("Gracias por Jugar");
            }
        }
    }
}
