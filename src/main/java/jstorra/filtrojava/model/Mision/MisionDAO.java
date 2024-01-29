package jstorra.filtrojava.model.Mision;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import jstorra.filtrojava.persistence.ConnectionDB;

public class MisionDAO {

    private static final String SELECT_MISION = "SELECT * FROM mision";

    public List<Mision> getAllMisiones() {
        List<Mision> misiones = new ArrayList<>();
        try (Connection connection = ConnectionDB.MySQConnection(); PreparedStatement ps = connection.prepareStatement(SELECT_MISION)) {

        } catch (SQLException e) {

        }
        return misiones;
    }
}
