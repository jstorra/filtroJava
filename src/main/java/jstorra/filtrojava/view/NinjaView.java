package jstorra.filtrojava.view;

import java.util.InputMismatchException;
import java.util.Scanner;
import jstorra.filtrojava.controller.NinjaController;
import jstorra.filtrojava.model.Ninja.Ninja;
import jstorra.filtrojava.model.Rango;

public class NinjaView {

    public static void initApp() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("\n---------- AGREGAR NINJA ----------\n");
            System.out.print("Ingresa el nombe del ninja: ");
            String nombre = scanner.nextLine();

            if (nombre.isEmpty()) {
                throw new Exception("\nError: El nombre no debe estar vacio.");
            }

            System.out.println("""
                    
                    Escoge el rango del ninja: 
                    1. Rango 1
                    2. Rango 2
                    3. Rango 3
                    """);

            System.out.print("Opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            Rango rango;
            if (opcion == 1) {
                rango = Rango.RANGO1;
            } else if (opcion == 2) {
                rango = Rango.RANGO2;
            } else if (opcion == 3) {
                rango = Rango.RANGO3;
            } else {
                throw new Exception("\nError: La opcion ingresada no es valida.");
            }
            
            System.out.print("\nIngresa la aldea a la que pertenece: ");
            String aldea = scanner.nextLine();
            
            if (aldea.isEmpty())
                throw new Exception("\nError: La aldea no debe estar vacia.");
            
            Ninja ninja = new Ninja();
            ninja.setNombre(nombre);
            ninja.setRango(rango);
            ninja.setAldea(aldea);
            
            NinjaController.addNinja(ninja);
            System.out.println("\nMensaje: El ninja ha sido registrado.");
            
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("\nError: El caracter ingresado no es valido.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
