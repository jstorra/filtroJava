package jstorra.filtrojava;

import java.util.List;
import jstorra.filtrojava.controller.MisionNinjaController;
import jstorra.filtrojava.model.MisionNinja.MisionNinja;

public class FiltroJava {

    public static void main(String[] args) {
        List<MisionNinja> misiones = MisionNinjaController.getAllMisionNinja();
        
        System.out.println(misiones);
        
    }
}
