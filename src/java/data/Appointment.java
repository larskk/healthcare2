package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Appointment {
    public static Boolean saveAppointment(int userID, int treatmentID, String date) {
        String sql = "INSERT INTO appointment (aptime, userID, treatmentID) Values (?,?,?);";
        
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            DBUtil.processException(ex);
            return false;
        }
    }
}

