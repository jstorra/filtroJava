package jstorra.filtrojava.controller;

import java.util.List;
import jstorra.filtrojava.model.Ninja.Ninja;
import jstorra.filtrojava.model.Ninja.NinjaDAO;

public class NinjaController {
    private static final NinjaDAO NINJADAO = new NinjaDAO();
    
    public static List<Ninja> getAllNinjas() {
        return NINJADAO.getAllNinjas();
    }
    
    public static Ninja getNinjaById(long ninjaId) {
        return NINJADAO.getNinjaById(ninjaId);
    }
    
    public static void addNinja(Ninja ninja) {
        NINJADAO.addNinja(ninja);
    }
}
