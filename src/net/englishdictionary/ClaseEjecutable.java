package net.englishdictionary;

import java.util.Scanner;

public class ClaseEjecutable {
    public static void main(String[] args) {
        Diccionario dictionary = new Diccionario();
        Scanner teclado = new Scanner(System.in);

        System.out.println("Bienvenido al diccionario!!");

        int opcion;
        do {
            System.out.println("----------------------");
            System.out.println("Menú:");
            System.out.println("1. Añadir palabra");
            System.out.println("2. Eliminar palabra");
            System.out.println("3. Existe palabra");
            System.out.println("4. Mostrar iniciales disponibles");
            System.out.println("5. Ver palabras por inicial");
            System.out.println("6. Cerrar programa");
            System.out.print("Elija una opcion : ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la palabra a agregar: ");
                    teclado.nextLine();
                    String agregarPalabra = teclado.nextLine();
                    dictionary.agregarPalabra(agregarPalabra);
                    break;
                case 2:
                    System.out.print("Ingrese la palabra a eliminar: ");
                    teclado.nextLine();
                    String quitarPalabra = teclado.nextLine();
                    dictionary.eliminarPalabra(quitarPalabra);
                    break;
                case 3:
                    System.out.print("Ingrese la palabra a buscar: ");
                    teclado.nextLine();
                    String buscarPalabra = teclado.nextLine();
                    dictionary.buscarPalabra(buscarPalabra);
                    break;
                case 4:
                    dictionary.mostrarInicialesDisponibles();
                    break;
                case 5:
                    System.out.print("Ingrese la inicial: ");
                    teclado.nextLine();
                    char inicial = teclado.nextLine().charAt(0);
                    dictionary.mostrarPalabrasPorInicial(inicial);
                    break;
                case 6:
                    System.out.println("Cerrando Programa.....");
                    break;
                default:
                    System.out.println("Porfa introduzca una opcion valida");
                    break;
            }
        } while (opcion != 6);

        teclado.close();
    }
}
