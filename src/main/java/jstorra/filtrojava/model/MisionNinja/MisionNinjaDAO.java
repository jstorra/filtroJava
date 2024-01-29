package jstorra.filtrojava.model.MisionNinja;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jstorra.filtrojava.persistence.ConnectionDB;

public class MisionNinjaDAO {

    private static final String SELECT_MISIONNINJA = "SELECT * FROM misionNinja";
    private static final String INSERT_MISIONNINJA = "INSERT INTO misionNinja (ninjaId, misionId, fechaInicio, fechaFin) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_MISIONNINJA = "UPDATE misionNinja SET fechaFin = ? WHERE ninjaId = ? AND misionId = ?";


    public List<MisionNinja> getAllMisionNinja() {
        List<MisionNinja> misionesNinja = new ArrayList<>();
        try (Connection connection = ConnectionDB.MySQConnection(); PreparedStatement ps = connection.prepareStatement(SELECT_MISIONNINJA)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    MisionNinja misionNinja = new MisionNinja();
                    misionNinja.setNinjaId(rs.getLong("ninjaId"));
                    misionNinja.setMisionId(rs.getLong("misionId"));
                    misionNinja.setFechaInicio(LocalDate.parse(rs.getString("fechaInicio")));
                    misionNinja.setFechaFin(rs.getString("fechaFin") == null ? null : LocalDate.parse(rs.getString("fechaFin")));
                    misionesNinja.add(misionNinja);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return misionesNinja;
    }

    public void addMisionNinja(MisionNinja misionNinja) {
        try (Connection connection = ConnectionDB.MySQConnection(); PreparedStatement ps = connection.prepareStatement(INSERT_MISIONNINJA)) {
            ps.setLong(1, misionNinja.getNinjaId());
            ps.setLong(2, misionNinja.getMisionId());
            ps.setString(3, misionNinja.getFechaInicio().toString());
            ps.setObject(4, null);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateMisionNinja(MisionNinja misionNinja) {
        try (Connection connection = ConnectionDB.MySQConnection(); PreparedStatement ps = connection.prepareStatement(UPDATE_MISIONNINJA)) {
            ps.setString(1, misionNinja.getFechaFin().toString());
            ps.setLong(2, misionNinja.getNinjaId());
            ps.setLong(3, misionNinja.getMisionId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
