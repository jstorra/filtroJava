package jstorra.filtrojava.controller;

import java.util.List;
import jstorra.filtrojava.model.Mision.Mision;
import jstorra.filtrojava.model.Mision.MisionDAO;

public class MisionController {
    private static final MisionDAO MISIONDAO = new MisionDAO();
    
    public static List<Mision> getAllMisiones() {
        return MISIONDAO.getAllMisiones();
    }
    
    public static Mision getMisionById(long misionId) {
        return MISIONDAO.getMisionById(misionId);
    }
}
