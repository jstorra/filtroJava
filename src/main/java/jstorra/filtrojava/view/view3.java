package jstorra.filtrojava.view;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import jstorra.filtrojava.controller.MisionNinjaController;
import jstorra.filtrojava.controller.NinjaController;
import jstorra.filtrojava.model.MisionNinja.MisionNinja;
import jstorra.filtrojava.model.Ninja.Ninja;

public class View3 {

    public static void initApp() {
        Scanner scanner = new Scanner(System.in);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./misionesCompletadas.txt"))) {
             List<MisionNinja> misionesCompletadas = MisionNinjaController.getAllMisionNinja().stream().filter(misionNinja -> misionNinja.getFechaFin() != null).toList();
            oos.writeObject(misionesCompletadas);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./misionesCompletadas.txt"))) {
            System.out.println("\n---------- NINJAS EXISTENTES ----------\n");

            List<Ninja> ninjas = NinjaController.getAllNinjas();

            ninjas.forEach(ninja -> System.out.println(ninja.getNinjaId() + ". " + ninja.getNombre().toUpperCase() + ", " + ninja.getRango().getNombre()));

            System.out.print("\nIngresa el ID del ninja: ");
            long ninjaId = scanner.nextLong();
            scanner.nextLine();

            boolean existeNinja = ninjas.stream().anyMatch(ninja -> ninja.getNinjaId() == ninjaId);

            if (!existeNinja)
                throw new Exception("\nError: El ninja no existe.");

            List<MisionNinja> misionesCompletadas = (List<MisionNinja>) ois.readObject();
            
            if (misionesCompletadas.isEmpty())
                throw new Exception("\nMensaje: No hay misiones completadas");
            
            boolean tiene = misionesCompletadas.stream().anyMatch(mision -> mision.getNinjaId() == ninjaId);
        
            if (!tiene)
                throw new Exception("\nMensaje: El ninja no tiene misiones completadas.");
            
            System.out.println("\n---------- MISIONES COMPLETADAS ----------\n");
            misionesCompletadas.stream().filter(mision -> mision.getNinjaId() == ninjaId).forEach(System.out::println);
            
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("\nError. El caracter ingresado no es valido.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
