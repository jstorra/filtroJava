package jstorra.filtrojava.model.Habilidad;

import java.sql.*;
import jstorra.filtrojava.persistence.ConnectionDB;

public class HabilidadDAO {

    private static final String INSERT_HABILIDAD = "INSERT INTO habilidad (ninjaId, nombre, descripcion) VALUES (?, ?, ?)";

    public void addHabilidad(Habilidad habilidad) {
        try (Connection connection = ConnectionDB.MySQConnection(); PreparedStatement ps = connection.prepareStatement(INSERT_HABILIDAD)) {
            ps.setLong(1, habilidad.getNinjaId());
            ps.setString(2, habilidad.getNombre());
            ps.setString(3, habilidad.getDescripcion());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
