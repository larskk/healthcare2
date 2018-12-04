package data;

import entity.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserManager {
    public static boolean createUser(User user) {
        String SQL = "Insert into user (firstName, lastName, pwd, email ,phone, role) values (?,?,?,?,?,?)";

        try (
            PreparedStatement pstmt = DBUtil.getConnection().prepareStatement(SQL);
            ) {
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getPhone());
            pstmt.setString(6, user.getRole());
            pstmt.executeUpdate();
            System.out.println("INserted!");
            return true;
        } catch (SQLException e) {
            DBUtil.processException(e);
            return false;
        }
    }
}
