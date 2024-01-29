package jstorra.filtrojava.model.Habilidad;

public class Habilidad {
    private long ninjaId;
    private String nombre;
    private String descripcion;

    public long getNinjaId() {
        return ninjaId;
    }

    public void setNinjaId(long ninjaId) {
        this.ninjaId = ninjaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Habilidad{" + "ninjaId=" + ninjaId + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
}
