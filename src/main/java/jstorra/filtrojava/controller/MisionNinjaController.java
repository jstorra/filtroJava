package jstorra.filtrojava.controller;

import java.util.List;
import jstorra.filtrojava.model.MisionNinja.MisionNinja;
import jstorra.filtrojava.model.MisionNinja.MisionNinjaDAO;

public class MisionNinjaController {
    private static final MisionNinjaDAO MISIONNINJADAO = new MisionNinjaDAO();
    
    public static List<MisionNinja> getAllMisionNinja() {
        return MISIONNINJADAO.getAllMisionNinja();
    }
    
    public static void addMisionNinja(MisionNinja misionNinja) {
        MISIONNINJADAO.addMisionNinja(misionNinja);
    }
    
    public static void updateMisionNinja(MisionNinja misionNinja) {
        MISIONNINJADAO.updateMisionNinja(misionNinja);
    }
}
