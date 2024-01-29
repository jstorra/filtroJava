package jstorra.filtrojava.model.Ninja;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import jstorra.filtrojava.model.Rango;
import jstorra.filtrojava.persistence.ConnectionDB;

public class NinjaDAO {

    private static final String SELECT_NINJA = "SELECT * FROM ninja";
    private static final String SELECT_NINJABYID = "SELECT * FROM ninja WHERE ninjaId = ?";
    private static final String INSERT_NINJA = "INSERT INTO ninja (nombre, rango, aldea) VALUES (?, ?, ?)";

    public List<Ninja> getAllNinjas() {
        List<Ninja> ninjas = new ArrayList<>();
        try (Connection connection = ConnectionDB.MySQConnection(); PreparedStatement ps = connection.prepareStatement(SELECT_NINJA)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Ninja ninja = new Ninja();
                    ninja.setNinjaId(rs.getLong("ninjaId"));
                    ninja.setNombre(rs.getString("nombre"));
                    ninja.setRango(Rango.valueOf(rs.getString("rango").toUpperCase()));
                    ninja.setAldea(rs.getString("aldea"));
                    ninjas.add(ninja);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ninjas;
    }
    
    public Ninja getNinjaById(long ninjaId) {
        Ninja ninja = new Ninja();
        try (Connection connection = ConnectionDB.MySQConnection(); PreparedStatement ps = connection.prepareStatement(SELECT_NINJABYID)) {
            ps.setLong(1, ninjaId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ninja.setNinjaId(rs.getLong("ninjaId"));
                    ninja.setNombre(rs.getString("nombre"));
                    ninja.setRango(Rango.valueOf(rs.getString("rango").toUpperCase()));
                    ninja.setAldea(rs.getString("aldea"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ninja;
    }
    
    public void addNinja(Ninja ninja) {
        try (Connection connection = ConnectionDB.MySQConnection(); PreparedStatement ps = connection.prepareStatement(INSERT_NINJA)) {
            ps.setString(1, ninja.getNombre());
            ps.setString(2, ninja.getRango().getNombre());
            ps.setString(3, ninja.getAldea());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
