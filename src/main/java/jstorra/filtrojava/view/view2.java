package jstorra.filtrojava.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import jstorra.filtrojava.controller.MisionController;
import jstorra.filtrojava.controller.NinjaController;
import jstorra.filtrojava.model.Mision.Mision;
import jstorra.filtrojava.model.Ninja.Ninja;

public class view2 {

    public static void initApp() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("\n---------- NINJAS EXISTENTES ----------\n");

            List<Ninja> ninjas = NinjaController.getAllNinjas();

            ninjas.forEach(ninja -> System.out.println(ninja.getNinjaId() + ". " + ninja.getNombre().toUpperCase()));

            System.out.print("\nIngresa el ID del ninja: ");
            long ninjaId = scanner.nextLong();
            scanner.nextLine();

            boolean existe = ninjas.stream().anyMatch(ninja -> ninja.getNinjaId() == ninjaId);

            if (!existe)
                throw new Exception("\nError: El ninja no existe.");
            
            Ninja ninja = NinjaController.getNinjaById(ninjaId);

            List<Mision> misiones = MisionController.getAllMisiones();

            misiones.stream()
                    .filter(mision -> mision.getRango().getNombre().equalsIgnoreCase(ninja.getRango().getNombre()))
                    .forEach(mision -> System.out.println(mision.getMisionId() + ". " + mision.getDescripcion() + ", Recompensa: " + mision.getRecompensa()));

        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("\nError: El caracter ingresado no es valido.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
