package jstorra.filtrojava.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import jstorra.filtrojava.controller.HabilidadController;
import jstorra.filtrojava.controller.NinjaController;
import jstorra.filtrojava.model.Habilidad.Habilidad;
import jstorra.filtrojava.model.Ninja.Ninja;

public class HabilidadView {
    
    public static void initApp() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("\n---------- AGREGAR HABILIDAD ----------\n");
            
            List<Ninja> ninjas = NinjaController.getAllNinjas();

            ninjas.forEach(ninja -> System.out.println(ninja.getNinjaId() + ". " + ninja.getNombre().toUpperCase()));

            System.out.print("\nIngresa el ID del ninja: ");
            long ninjaId = scanner.nextLong();
            scanner.nextLine();

            boolean existe = ninjas.stream().anyMatch(ninja -> ninja.getNinjaId() == ninjaId);

            if (!existe)
                throw new Exception("\nError: El ninja no existe.");
            
            System.out.print("Ingrese el nombre de la habilidad: ");
            String nombre = scanner.nextLine();
            
            if (nombre.isEmpty())
                throw new Exception("\nError: El nombre no debe estar vacio.");

            System.out.print("Ingresa la descripcion de la habilidad: ");
            String descripcion = scanner.nextLine();

            if (descripcion.isEmpty())
                throw new Exception("\nError: La descripcion no debe estar vacia.");

            Habilidad habilidad = new Habilidad();
            habilidad.setNinjaId(ninjaId);
            habilidad.setNombre(nombre);
            habilidad.setDescripcion(descripcion);
            
            HabilidadController.addHabilidad(habilidad);
            System.out.println("\nMensaje: La habilidad ha sido registrada.");
            
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("\nError: El caracter ingresado no es valido.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
