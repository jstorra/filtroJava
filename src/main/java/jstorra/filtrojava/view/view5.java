package jstorra.filtrojava.view;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import jstorra.filtrojava.controller.MisionNinjaController;
import jstorra.filtrojava.model.MisionNinja.MisionNinja;

public class View5 {

    public static void initApp() {
        Scanner scanner = new Scanner(System.in);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./misionesCompletadas.txt"))) {
            System.out.println("\n---------- MISIONES PARA COMPLETAR ----------\n");
            
            List<MisionNinja> misionesPorCompletar = MisionNinjaController.getAllMisionNinja().stream().filter(misionNinja -> misionNinja.getFechaFin() == null).toList();
            
            for (int i = 0; i < misionesPorCompletar.size(); i++) {
                System.out.println("ID: " + (i + 1) + ". " + misionesPorCompletar.get(i));
            }
            
            System.out.print("\nIngresa el ID de la mision a completar: ");
            int misionNinjaId = scanner.nextInt();
            scanner.nextLine();
            
            if (misionNinjaId < 1 || misionNinjaId > misionesPorCompletar.size())
                throw new Exception("\nError: La mision a completar no existe.");
            
            System.out.print("Ingresa le fecha de finalizacion (YYYY-MM-DD): ");
            LocalDate fechaFin = LocalDate.parse(scanner.nextLine());
            
            MisionNinja misionNinja = misionesPorCompletar.get(misionNinjaId - 1);
            misionNinja.setFechaFin(fechaFin);
            
            MisionNinjaController.updateMisionNinja(misionNinja);
            
            List<MisionNinja> misionesCompletadas = MisionNinjaController.getAllMisionNinja().stream().filter(mision -> mision.getFechaFin() != null).toList();
            oos.writeObject(misionesCompletadas);
            
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("\nError: El caracter ingresado no es valido.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
