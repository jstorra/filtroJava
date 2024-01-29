package jstorra.filtrojava.model.Mision;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import jstorra.filtrojava.model.Rango;
import jstorra.filtrojava.persistence.ConnectionDB;

public class MisionDAO {

    private static final String SELECT_MISION = "SELECT * FROM mision";
    private static final String SELECT_MISIONBYID = "SELECT * FROM mision WHERE misionId = ?";

    public List<Mision> getAllMisiones() {
        List<Mision> misiones = new ArrayList<>();
        try (Connection connection = ConnectionDB.MySQConnection(); PreparedStatement ps = connection.prepareStatement(SELECT_MISION)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Mision mision = new Mision();
                    mision.setMisionId(rs.getLong("misionId"));
                    mision.setDescripcion(rs.getString("descripcion"));
                    mision.setRango(Rango.valueOf(rs.getString("rango").toUpperCase()));
                    mision.setRecompensa(rs.getDouble("recompensa"));
                    misiones.add(mision);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return misiones;
    }
    
    public Mision getMisionById(long misionId) {
        Mision mision = new Mision();
        try (Connection connection = ConnectionDB.MySQConnection(); PreparedStatement ps = connection.prepareStatement(SELECT_MISIONBYID)) {
            ps.setLong(1, misionId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    mision.setMisionId(rs.getLong("misionId"));
                    mision.setDescripcion(rs.getString("descripcion"));
                    mision.setRango(Rango.valueOf(rs.getString("rango").toUpperCase()));
                    mision.setRecompensa(rs.getDouble("recompensa"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mision;
    }
}
