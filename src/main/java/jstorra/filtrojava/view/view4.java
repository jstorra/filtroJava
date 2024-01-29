package jstorra.filtrojava.view;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import jstorra.filtrojava.controller.MisionController;
import jstorra.filtrojava.controller.MisionNinjaController;
import jstorra.filtrojava.controller.NinjaController;
import jstorra.filtrojava.model.Mision.Mision;
import jstorra.filtrojava.model.MisionNinja.MisionNinja;
import jstorra.filtrojava.model.Ninja.Ninja;

public class View4 {

    public static void initApp() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("\n---------- NINJAS EXISTENTES ----------\n");

            List<Ninja> ninjas = NinjaController.getAllNinjas();

            ninjas.forEach(ninja -> System.out.println(ninja.getNinjaId() + ". " + ninja.getNombre().toUpperCase() + ", " + ninja.getRango().getNombre()));

            System.out.print("\nIngresa el ID del ninja: ");
            long ninjaId = scanner.nextLong();
            scanner.nextLine();

            boolean existeNinja = ninjas.stream().anyMatch(ninja -> ninja.getNinjaId() == ninjaId);

            if (!existeNinja)
                throw new Exception("\nError: El ninja no existe.");

            Ninja ninja = NinjaController.getNinjaById(ninjaId);

            // Misiones
            System.out.println("\n---------- MISIONES EXISTENTES ----------\n");
            
            List<Mision> misiones = MisionController.getAllMisiones();

            misiones.forEach(mision -> System.out.println(mision.getMisionId() + ". " + mision.getDescripcion() + ", " + mision.getRango().getNombre() + ", Recompensa: " + mision.getRecompensa()));

            System.out.print("\nIngresa el ID de la mision: ");
            long misionId = scanner.nextLong();
            scanner.nextLine();

            boolean existeMision = misiones.stream().anyMatch(mision -> mision.getMisionId() == misionId);

            if (!existeMision) {
                throw new Exception("\nError: La mision no existe.");
            }

            Mision mision = MisionController.getMisionById(misionId);
            
            if (!mision.getRango().getNombre().equalsIgnoreCase(ninja.getRango().getNombre()))
                throw new Exception("\nError: El rango de la mision debe coincidir con el del ninja.");
            
            System.out.print("Ingresa le fecha de inicio (YYYY-MM-DD): ");
            LocalDate fechaInicio = LocalDate.parse(scanner.nextLine());
            
            MisionNinja misionNinja = new MisionNinja();
            misionNinja.setNinjaId(ninjaId);
            misionNinja.setMisionId(misionId);
            misionNinja.setFechaInicio(fechaInicio);

            MisionNinjaController.addMisionNinja(misionNinja);
            
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("\nError: El caracter ingresado no es valido.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
