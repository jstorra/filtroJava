package jstorra.filtrojava.view;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import jstorra.filtrojava.controller.MisionNinjaController;
import jstorra.filtrojava.model.MisionNinja.MisionNinja;

public class View6 {

    public static void initApp() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./misionesCompletadas.txt"))) {
            List<MisionNinja> misionesCompletadas = MisionNinjaController.getAllMisionNinja().stream().filter(misionNinja -> misionNinja.getFechaFin() != null).toList();
            oos.writeObject(misionesCompletadas);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./misionesCompletadas.txt"))) {
            System.out.println("\n---------- MISIONES COMPLETADAS ----------\n");
            
            List<MisionNinja> misionesCompletadas = (List<MisionNinja>) ois.readObject();
            
            if (misionesCompletadas.isEmpty())
                throw new Exception("\nMensaje: No hay misiones completadas");
            
            misionesCompletadas.stream().forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
