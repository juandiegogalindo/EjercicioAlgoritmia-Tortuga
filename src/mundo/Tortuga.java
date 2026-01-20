package mundo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que se encarga del manejo de la tortuga y de como esta hace sus
 * movimientos
 *
 * @author Diego Betancur
 * @author Juan Pablo Coronado
 * @author Juan Diego Galindo
 * @author Sofia Torres
 */
public class Tortuga {

    public String lapiz; 
    private int fila;
    private int columna;
    private String orientacion;
    private int movimientos;
    private String[][] matriz;
    private ArrayList guardado;

    /**
     * Metodo que se encarga de establecer la tortuga en un estado inicial
     * específico
     */
    public Tortuga() {
        lapiz = " ";
        fila = 0;
        columna = 0;
        orientacion = ">";
        matriz = new String[30][30];
        Tablero.llenarMatriz(matriz);
        guardado = new ArrayList();
    }

    /**
     * Metodo que se encarga de iniciar el juego imprimiento el tablero
     */
    public void InicioMatriz() {
        Tablero.ImprimirJuego(matriz, fila, columna, orientacion);
    }

    /**
     * Metodo que se encarga de conocer que quiere hacer el usuario con la
     * tortuaga (Subir, Marcar o borrar)
     *
     * @param RespuestaLapiz
     */
    public void OpcionesLapiz(int RespuestaLapiz) {
        switch (RespuestaLapiz) {
            case 1:
                lapiz = "sl";
                OpcionesMovimientos();
                break;
            case 2:
                lapiz = "bl";
                OpcionesMovimientos();
                break;
            case 3:
                lapiz = "bo";
                OpcionesMovimientos();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                lapiz = "sl";
                OpcionesMovimientos();
                break;
        }
    }

    /**
     * Metodo que se encarga de conocer los movimientos y la cantidad de pasos
     * que se quiere mover
     */
    public void OpcionesMovimientos() {
        Scanner scanner = new Scanner(System.in);
        String RespuestaMovimiento;

        System.out.println("Cual va a ser el siguiente movimiento?");
        System.out.println("av. Avanzar");
        System.out.println("gi. Girar");

        RespuestaMovimiento = scanner.next();
        guardado.add(RespuestaMovimiento);
        if (RespuestaMovimiento.equals("av")) {

            System.out.println("Cuantas casillas desea avanzar");
            movimientos = scanner.nextInt();
            for (int i = 0; i < matriz.length; i++) {
              if (movimientos < matriz.length) {
               guardado.add(movimientos);
               JugarTortuga(movimientos); 
               break;
            } else {
                  System.out.println("El numero de casillas que ingresaste, NO ES VALIDO, volvamos a empezar");
              } 
              break;
            }
        } else if (RespuestaMovimiento.equals("gi")) {
            Direccion();
        }
    }

    /**
     * Metodoque se encarga de conocer la direccion y asignar el simbolo
     * correspondiente
     */
    public void Direccion() {
        Scanner sc = new Scanner(System.in);
        String RespuestaDireccion;

        System.out.println("A que direccion quiere girar? ");
        System.out.println("8. Arriba");
        System.out.println("9. Diagonal Arriba Derecha");
        System.out.println("6. Derecha");
        System.out.println("3. Diagonal Abajo Derecha");
        System.out.println("2. Abajo");
        System.out.println("1. Diagonal Abajo Izquierda");
        System.out.println("4. Izquierda");
        System.out.println("7. Diagonal Arriba Izquierda");

        RespuestaDireccion = sc.next();
        guardado.add(RespuestaDireccion);

        if (RespuestaDireccion.equals("8")) {
            orientacion = "^";
        } else if (RespuestaDireccion.equals("9")) {
            orientacion = "/";
        } else if (RespuestaDireccion.equals("6")) {
            orientacion = ">";
        } else if (RespuestaDireccion.equals("3")) {
            orientacion = "+";
        } else if (RespuestaDireccion.equals("2")) {
            orientacion = "v";
        } else if (RespuestaDireccion.equals("1")) {
            orientacion = "~";
        } else if (RespuestaDireccion.equals("4")) {
            orientacion = "<";
        } else if (RespuestaDireccion.equals("7")) {
            orientacion = "=";
        }
        Tablero.ImprimirJuego(matriz, fila, columna, orientacion);
    }

    /**
     * Metodo que se encarga de conocer el simbolo de la direccion y retornar
     * otro valor de modo que no quede null
     *
     * @return
     */
    public String SimbolosDireccion() {
        if (orientacion.equals(">")) {
            return "y";
        } else if (orientacion.equals("<")) {
            return "-y";
        } else if (orientacion.equals("^")) {
            return "-x";
        } else if (orientacion.equals("v")) {
            return "x";
        } else if (orientacion.equals("/")) {
            return "z";
        } else if (orientacion.equals("+")) {
            return "-z";
        } else if (orientacion.equals("~")) {
            return "-w";
        } else if (orientacion.equals("=")) {
            return "w";
        }
        return "";
    }

    /**
     * Metodo encargado de conocer la posicion de la tortuga y hacer la funcion
     * del lapiz dependiendo de que usuario necesite
     *
     * @param cantidad
     */
    public void JugarTortuga(int cantidad) {
        String Direccion = SimbolosDireccion();
        if (lapiz.equals("sl")) {
            if (Direccion.equals("x")) {
                if (fila + cantidad < 30) {
                    fila += cantidad;
                } else {
                    System.out.println("El numero de movimientos esta superando el tamaño del tablero");
                    return;
                }
            } else if (Direccion.equals("-x")) {
                if (fila - cantidad >= 0) {
                    fila -= cantidad;
                } else {
                    System.out.println("El numero de movimientos esta superando el tamaño del tablero");
                    return;
                }
            } else if (Direccion.equals("y")) {
                if (columna + cantidad < 30) {
                    columna += cantidad;
                } else {
                    System.out.println("El numero de movimientos esta superando el tamaño del tablero");
                    return;
                }
            } else if (Direccion.equals("-y")) {
                if (columna - cantidad >= 0) {
                    columna -= cantidad;
                } else {
                    System.out.println("El numero de movimientos esta superando el tamaño del tablero");
                    return;
                }
            } // Movimientos Diagonales
            else if (Direccion.equals("z")) {
                if (columna + cantidad < 30 && fila - cantidad >= 0) {
                    fila -= cantidad;
                    columna += cantidad;
                } else {
                    System.out.println("El numero de movimientos esta superando el tamaño del tablero");
                    return;
                }
            } else if (Direccion.equals("-z")) {
                if (columna + cantidad < 30 && fila + cantidad < 30) {
                    fila += cantidad;
                    columna += cantidad;
                } else {
                    System.out.println("El numero de movimientos esta superando el tamaño del tablero");
                    return;
                }
            } else if (Direccion.equals("-w")) {
                if (columna - cantidad >= 0 && fila + cantidad < 30) {
                    fila += cantidad;
                    columna -= cantidad;
                } else {
                    System.out.println("El numero de movimientos esta superando el tamaño del tablero");
                    return;
                }
            } else if (Direccion.equals("w")) {
                if (columna - cantidad >= 0 && fila - cantidad >= 0) {
                    fila -= cantidad;
                    columna -= cantidad;
                } else {
                    System.out.println("El numero de movimientos esta superando el tamaño del tablero");
                    return;
                }
            }
            Tablero.ImprimirJuego(matriz, fila, columna, orientacion);
        } else if (lapiz.equals("bl")) {
            if (Direccion.equals("x")) {
                for (int i = 0; i < cantidad; i++) {
                    matriz[fila + i][columna] = "*";
                }
                fila = fila + cantidad;
            } else if (Direccion.equals("-x")) {
                for (int i = 0; i < cantidad; i++) {
                    matriz[fila - i][columna] = "*";
                }
                fila = fila - cantidad;
            } else if (Direccion.equals("y")) {
                for (int i = 0; i < cantidad; i++) {
                    matriz[fila][columna + i] = "*";
                }
                columna = columna + cantidad;
            } else if (Direccion.equals("-y")) {
                for (int i = 0; i < cantidad; i++) {
                    matriz[fila][columna - i] = "*";
                }
                columna = columna - cantidad;
                // Diagonales
            } else if (Direccion.equals("z")) {
                for (int i = 0; i < cantidad; i++) {
                    matriz[fila - i][columna + i] = "*";
                }
                fila = fila - cantidad;
                columna = columna + cantidad;
            } else if (Direccion.equals("-z")) {
                for (int i = 0; i < cantidad; i++) {
                    matriz[fila + i][columna + i] = "*";
                }
                fila = fila + cantidad;
                columna = columna + cantidad;
            } else if (Direccion.equals("-w")) {
                for (int i = 0; i < cantidad; i++) {
                    matriz[fila + i][columna - i] = "*";
                }
                fila = fila + cantidad;
                columna = columna - cantidad;
            } else if (Direccion.equals("w")) {
                for (int i = 0; i < cantidad; i++) {
                    matriz[fila - i][columna - i] = "*";
                }
                fila = fila - cantidad;
                columna = columna - cantidad;
            }
            Tablero.ImprimirJuego(matriz, fila, columna, orientacion);
        } else if (lapiz.equals("bo")) {
            if (Direccion.equals("x")) {
                for (int i = 0; i < cantidad; i++) {
                    matriz[fila + i][columna] = "-";
                }
                fila = fila + cantidad;
            } else if (Direccion.equals("-x")) {
                for (int i = 0; i < cantidad; i++) {
                    matriz[fila - i][columna] = "-";
                }
                fila = fila - cantidad;
            } else if (Direccion.equals("y")) {
                for (int i = 0; i < cantidad; i++) {
                    matriz[fila][columna + i] = "-";
                }
                columna = columna + cantidad;
            } else if (Direccion.equals("-y")) {
                for (int i = 0; i < cantidad; i++) {
                    matriz[fila][columna - i] = "-";
                }
                columna = columna - cantidad;
                // Diagonales
            } else if (Direccion.equals("z")) {
                for (int i = 0; i < cantidad; i++) {
                    matriz[fila - i][columna + i] = "-";
                }
                fila = fila - cantidad;
                columna = columna + cantidad;
            } else if (Direccion.equals("-z")) {
                for (int i = 0; i < cantidad; i++) {
                    matriz[fila + i][columna + i] = "-";
                }
                fila = fila + cantidad;
                columna = columna + cantidad;
            } else if (Direccion.equals("-w")) {
                for (int i = 0; i < cantidad; i++) {
                    matriz[fila + i][columna - i] = "-";
                }
                fila = fila + cantidad;
                columna = columna - cantidad;
            } else if (Direccion.equals("w")) {
                for (int i = 0; i < cantidad; i++) {
                    matriz[fila - i][columna - i] = "-";
                }
                fila = fila - cantidad;
                columna = columna - cantidad;
            }
            Tablero.ImprimirJuego(matriz, fila, columna, orientacion);
        }
    }

    /**
     * Metodo get que permite obtener la lista "Guardado" desde fuera de la
     * clase
     *
     * @return
     */
    public ArrayList<String> getGuardado() {
        return guardado;
    }

    /**
     * Metodo set que permite la modificacion de la lista guardado desde fuera
     * de la clase
     *
     * @param guardado
     */
    public void setGuardado(ArrayList<String> guardado) {
        this.guardado = guardado;
    }

    /**
     * Metodo para reiniciar o limpir la lista guardado
     */
    public void vaciar() {
        guardado.removeAll(guardado);
    }
}
