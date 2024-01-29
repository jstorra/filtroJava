package jstorra.filtrojava.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("""
                                   
                                   ---------- MENU PRINCIPAL ----------
                                   
                                   1. Listar ninjas y habilidades
                                   2. Misiones disponibles para ninja
                                   3. Misiones completadas por ninja
                                   4. Asignar misiones
                                   5. Completar mision
                                   6. Mostrar todas las misiones completadas
                                   0. Salir
                                   """);

                System.out.print("Opcion: ");
                int opcion = scanner.nextInt();
                if (opcion == 0) {
                    System.out.println("\nSaliendo...");
                    break;
                } else if (opcion == 1) {
                    view1.initApp();
                } else if (opcion == 2) {
                    view2.initApp();
                } else if (opcion == 3) {
                    view3.initApp();
                } else if (opcion == 4) {
                    view4.initApp();
                } else if (opcion == 5) {
                    view5.initApp();
                } else if (opcion == 6) {
                    view6.initApp();
                } else {
                    throw new Exception("\nError: La opcion ingresada no es valida.");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("\nError: El caracter ingresado no es valido.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
