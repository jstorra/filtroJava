package jstorra.filtrojava.model.Ninja;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import jstorra.filtrojava.model.Rango;
import jstorra.filtrojava.persistence.ConnectionDB;

public class NinjaDAO {

    private static final String SELECT_NINJA = "SELECT * FROM ninja";

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
}
