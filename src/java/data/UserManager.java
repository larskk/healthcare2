package data;

import static data.DBUtil.getConnection;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserManager {

  public static List<User> getAllUsers() {
    String sql = "SELECT * FROM user JOIN role ON role.roleID=user.roleID";
    List<User> users = new ArrayList();
    try {
      Connection conn = getConnection();
      PreparedStatement ps;
      ps = conn.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        String role = rs.getString("roleName");
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

  public static boolean createUser(String firstName, String lastName, String pwd, String email, String phone, int roleID) {
    String sql = "Insert into user (firstName, lastName, pwd, email ,phone, roleID) values (?,?,?,?,?,?)";

    try {
      Connection conn = DBUtil.getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, firstName);
      ps.setString(2, lastName);
      ps.setString(3, pwd);
      ps.setString(4, email);
      ps.setString(5, phone);
      ps.setInt(6, roleID);
      ps.executeUpdate();
      return true;
    } catch (SQLException ex) {
      DBUtil.processException(ex);
      return false;
    }
  }

  public static boolean validateUser(String email, String pwd) {
    String sql = "SELECT email, pwd FROM user WHERE email = ?";
    try {
      Connection conn = DBUtil.getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, email);
      ResultSet rs = ps.executeQuery();
      if (rs.next() && rs.getString("pwd").equals(pwd)) {
        return true;
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      return false;
    }
    return false;
  }

  public static User getUser(String email) {
    String sql = "SELECT * FROM user JOIN role ON user.roleID=role.roleID WHERE email = ?";
    try {
      Connection conn = DBUtil.getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, email);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        User user = new User();
        user.setEmail(email);
        user.setFirstName(rs.getString("firstName"));
        user.setLastName(rs.getString("lastName"));
        user.setRole(rs.getString("roleName"));
        user.setPhone(rs.getString("phone"));
        return user;
      }
    } catch (SQLException ex) {
      DBUtil.processException(ex);
      return null;
    }
    return null;
  }

  public static void main(String[] args) {
    //if (createUser("Jens", "Lyn", "p123", "jl@post.dk", "44661213", 1)) System.out.println("Did it!");
    LocalDateTime dt = LocalDateTime.now();
    System.out.println(dt);

    List<User> brugere = UserManager.getAllUsers();
    for (User bruger : brugere) {
      System.out.println("Brugers fornavn:\t" + bruger.getFirstName());
      System.out.println("Brugers rolle:\t\t" + bruger.getRole());
      System.out.println("");
    }
  }
}
