package jstorra.filtrojava.controller;

import jstorra.filtrojava.model.Habilidad.Habilidad;
import jstorra.filtrojava.model.Habilidad.HabilidadDAO;

public class HabilidadController {
    private static final HabilidadDAO HABILIDADDAO =new HabilidadDAO();
    
    public static void addHabilidad(Habilidad habilidad) {
        HABILIDADDAO.addHabilidad(habilidad);
    }
}
