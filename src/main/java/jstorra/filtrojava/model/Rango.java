package jstorra.filtrojava.model;

public enum Rango {
    RANGO1("rango1"),
    RANGO2("rango2"),
    RANGO3("rango3");
    
    private String nombre;
    
    private Rango(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
