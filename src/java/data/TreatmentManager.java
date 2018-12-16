package data;

import entity.Treatment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TreatmentManager {

    public static String getName(int ID) {
        String sql = "SELECT * FROM treatment WHERE treatmentID = ?";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("treatmentName");
            }
        } catch (SQLException ex) {
            DBUtil.processException(ex);
            return null;
        }
        return null;
    }
}
