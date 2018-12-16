package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Misc {
    public static String getRoleName(int roleID) {
        String sql = "SELECT roleName FROM role WHERE roleID = ?";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, roleID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("roleName");
            }
        } catch (SQLException ex) {
            DBUtil.processException(ex);
            return null;
        }
        return null;
    }
}
