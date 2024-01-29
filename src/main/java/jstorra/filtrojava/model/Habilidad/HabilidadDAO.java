package jstorra.filtrojava.model.Habilidad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import jstorra.filtrojava.persistence.ConnectionDB;

public class HabilidadDAO {

    private static final String SELECT_HABILIDAD = "SELECT * FROM habilidad";
    private static final String INSERT_HABILIDAD = "INSERT INTO habilidad (ninjaId, nombre, descripcion) VALUES (?, ?, ?)";

    public List<Habilidad> getAllHabilidades() {
        List<Habilidad> habilidades = new ArrayList<>();
        try (Connection connection = ConnectionDB.MySQConnection(); PreparedStatement ps = connection.prepareStatement(SELECT_HABILIDAD)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Habilidad habilidad = new Habilidad();
                    habilidad.setNinjaId(rs.getLong("ninjaId"));
                    habilidad.setNombre(rs.getString("nombre"));
                    habilidad.setDescripcion(rs.getString("descripcion"));
                    habilidades.add(habilidad);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return habilidades;
    }

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
