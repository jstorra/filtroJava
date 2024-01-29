package jstorra.filtrojava.model.MisionNinja;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jstorra.filtrojava.persistence.ConnectionDB;

public class MisionNinjaDAO {

    private static final String SELECT_MISIONNINJA = "SELECT * FROM misionNinja";
    private static final String INSERT_MISIONNINJA = "INSERT INTO misionNinja (ninjaId, misionId, fechaInicio, fechaFin) VALUES (?, ?, ?, ?)";

    public List<MisionNinja> getAllMisionNinja() {
        List<MisionNinja> misionesNinja = new ArrayList<>();
        try (Connection connection = ConnectionDB.MySQConnection(); PreparedStatement ps = connection.prepareStatement(SELECT_MISIONNINJA)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    MisionNinja misionNinja = new MisionNinja();
                    misionNinja.setNinjaId(rs.getLong("ninjaId"));
                    misionNinja.setMisionId(rs.getLong("misionId"));
                    misionNinja.setFechaInicio(LocalDate.parse(rs.getString("fechaInicio")));
//                    misionNinja.setFechaFin(LocalDate.parse(rs.getString("fechaFin")));
                    misionesNinja.add(misionNinja);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(misionesNinja);
        return misionesNinja;
    }

    public static void addMisionNinja(MisionNinja misionNinja) {
        try (Connection connection = ConnectionDB.MySQConnection(); PreparedStatement ps = connection.prepareStatement(INSERT_MISIONNINJA)) {
            ps.setLong(1, misionNinja.getNinjaId());
            ps.setLong(1, misionNinja.getMisionId());
            ps.setString(1, misionNinja.getFechaInicio().toString());
            ps.setString(1, misionNinja.getFechaFin().toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
