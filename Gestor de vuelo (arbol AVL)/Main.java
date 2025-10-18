package carlos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArbolAVL avl = new ArbolAVL();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== Sistema de Gestión de Vuelos (AVL) de: Carlos,Yesenia y Andres ===");
            System.out.println("1. Registrar vuelo");
            System.out.println("2. Buscar vuelo por número");
            System.out.println("3. Buscar vuelos por destino");
            System.out.println("4. Mostrar recorridos");
            System.out.println("5. Eliminar vuelo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Número de vuelo: ");
                    int num = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Origen: ");
                    String origen = sc.nextLine();
                    System.out.print("Destino: ");
                    String destino = sc.nextLine();
                    System.out.print("Hora: ");
                    String hora = sc.nextLine();
                    System.out.print("Aerolínea: ");
                    String aerolinea = sc.nextLine();

                    Vuelo v = new Vuelo(num, origen, destino, hora, aerolinea);
                    avl.raiz = avl.insertar(avl.raiz, v);
                    System.out.println("Vuelo registrado correctamente.");
                }

                case 2 -> {
                    System.out.print("Ingrese número de vuelo a buscar: ");
                    int buscarNum = sc.nextInt();
                    Vuelo encontrado = avl.buscarPorNumero(avl.raiz, buscarNum);
                    if (encontrado != null) {
                        System.out.println("Vuelo encontrado:");
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Vuelo no encontrado.");
                    }
                }

                case 3 -> {
                    System.out.print("Ingrese destino a buscar: ");
                    String destinoBuscado = sc.nextLine();
                    System.out.println("Resultados de vuelos con destino a " + destinoBuscado + ":");
                    avl.buscarPorDestino(avl.raiz, destinoBuscado);
                }

                case 4 -> {
                    System.out.println("\n--- Recorrido INORDEN ---");
                    avl.inOrdenNumeros(avl.raiz);
                    System.out.println("\n--- Recorrido PREORDEN ---");
                    avl.preOrdenNumeros(avl.raiz);
                    System.out.println("\n--- Recorrido POSTORDEN ---");
                    avl.postOrdenNumeros(avl.raiz);
                    System.out.println();
                }

                case 5 -> {
                    System.out.print("Ingrese número de vuelo a eliminar: ");
                    int eliminarNum = sc.nextInt();
                    avl.raiz = avl.eliminar(avl.raiz, eliminarNum);
                    System.out.println("Vuelo eliminado (si existía).");
                }

                case 6 -> System.out.println("Saliendo del sistema...");

                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 6);

        sc.close();
    }
}