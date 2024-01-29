package jstorra.filtrojava.view;

import java.util.List;
import jstorra.filtrojava.controller.HabilidadController;
import jstorra.filtrojava.controller.NinjaController;
import jstorra.filtrojava.model.Habilidad.Habilidad;
import jstorra.filtrojava.model.Ninja.Ninja;

public class View1 {

    public static void initApp() {
        System.out.println("\n---------- NINJAS Y HABILIDADES ----------");

        List<Ninja> ninjas = NinjaController.getAllNinjas();
        List<Habilidad> habilidades = HabilidadController.getAllHabilidades();

        for (Ninja ninja : ninjas) {
            System.out.println("\n" + ninja.getNombre().toUpperCase());

            boolean tiene = habilidades.stream().anyMatch(habilidad -> habilidad.getNinjaId() == ninja.getNinjaId());

            if (!tiene) {
                System.out.println("- No tiene habilidades");
            } else {
                habilidades.stream()
                        .filter(habilidad -> habilidad.getNinjaId() == ninja.getNinjaId())
                        .forEach(habilidad -> System.out.println("- " + habilidad.getNombre() + ": " + habilidad.getDescripcion()));
            }
        }
    }
}
