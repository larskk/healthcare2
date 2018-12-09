package data;

import static data.DBUtil.getConnection;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Show {
    public static void main1(String[] args) throws SQLException {
        String sql = "SELECT * FROM user";
        try {
            Connection conn = getConnection();
            System.out.println("Connected!");
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String firstName = rs.getString("firstName");
                System.out.println("First name: " + firstName);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main2(String[] args) throws SQLException {
        String sql = "INSERT INTO user (firstName, lastName) VALUES (?,?)";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Jens");
            ps.setString(2, "Andersen");
            ps.executeUpdate();
            System.out.println("Inserted!");

        } catch (SQLException ex) {
            DBUtil.processException(ex);
        }
    }
    public static void main(String[] args) throws SQLException {
        List<User> users = UserManager.getAllUsers();
        for (User user : users) {
            String name = user.getFirstName();
            System.out.println(name);
        }
        
    }
}
