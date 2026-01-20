package mundo;

/**
 * Clase que se encarga de crear, llenar e imprimir nuestro tablero donde se jugara
 * @author Diego Betancur
 * @author Juan Pablo Coronado
 * @author Juan Diego Galindo
 * @author Sofia Torres
 */
public class Tablero {
/**
 * Metodo que se usa para imprimir la matriz en pantalla
 * @param matriz
 * @param fila
 * @param columna
 * @param orientacion 
 */
   public static void ImprimirJuego(String[][] matriz, int fila, int columna, String orientacion) {
       for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (i == fila && j == columna) {
                    System.out.print(orientacion + " ");
                } else {
                    System.out.print(matriz[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
/**
 *  Metodo para llenar el tablero de puros guiones (-)
 * @param matriz 
 */
    public static void llenarMatriz(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = "-";
            }
        }
    }
}