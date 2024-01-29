package jstorra.filtrojava.view;

import java.util.InputMismatchException;
import java.util.Scanner;
import jstorra.filtrojava.controller.MisionController;
import jstorra.filtrojava.model.Mision.Mision;
import jstorra.filtrojava.model.Rango;

public class MisionView {
    
    public static void initApp() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("\n---------- AGREGAR MISION ----------\n");
            System.out.print("Ingresa la descripcion de la mision: ");
            String descripcion = scanner.nextLine();

            if (descripcion.isEmpty()) {
                throw new Exception("\nError: La descripcion no debe estar vacia.");
            }

            System.out.println("""
                    
                    Escoge el rango de la mision: 
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
            
            System.out.print("\nIngresa la recompensa: ");
            double recompensa = scanner.nextDouble();
            
            if (recompensa <= 0)
                throw new Exception("\nError: La recompensa no es valida.");
            
            Mision mision = new Mision();
            mision.setDescripcion(descripcion);
            mision.setRango(rango);
            mision.setRecompensa(recompensa);
            
            MisionController.addMision(mision);
            System.out.println("\nMensaje: La mision ha sido registrada.");
            
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("\nError: El caracter ingresado no es valido.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
