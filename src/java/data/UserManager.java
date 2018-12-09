package data;

import static data.DBUtil.getConnection;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserManager {

    public static List<User> getAllUsers() {
        String sql = "SELECT * FROM user";
        List<User> users = new ArrayList();
        try {
            Connection conn = getConnection();
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String role = rs.getString("role");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String password = rs.getString("pwd");
                User user = new User(role, firstName, lastName, email, phone, password);
                users.add(user);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    public static boolean createUser(User user) {
        String sql = "Insert into user (firstName, lastName, pwd, email ,phone, role) values (?,?,?,?,?,?)";

        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPhone());
            ps.setString(6, user.getRole());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            DBUtil.processException(ex);
            return false;
        }
    }
}
