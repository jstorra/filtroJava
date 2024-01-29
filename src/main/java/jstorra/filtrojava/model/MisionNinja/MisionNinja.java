package jstorra.filtrojava.model.MisionNinja;

import java.time.LocalDate;

public class MisionNinja {
    private long ninjaId;
    private long misionId;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public long getNinjaId() {
        return ninjaId;
    }

    public void setNinjaId(long ninjaId) {
        this.ninjaId = ninjaId;
    }

    public long getMisionId() {
        return misionId;
    }

    public void setMisionId(long misionId) {
        this.misionId = misionId;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "MisionNinja{" + "ninjaId=" + ninjaId + ", misionId=" + misionId + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + '}';
    }
}
