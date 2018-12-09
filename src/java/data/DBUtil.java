package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

    //private static final String DRIVER = "com.mysql.jdbc.Driver";    
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost/healthCare?serverTimezone=UTC&noAccessToProcedureBodies=true";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        }
        return conn;
    }

    public static void processException(SQLException e) {
        System.err.println("Error message: " + e.getMessage());
        System.err.println("Error code: " + e.getErrorCode());
        System.err.println("SQL state: " + e.getSQLState());
    }

    public static void main(String[] args) {
        String sql = "SELECT * FROM user";
        try (
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            //Connection conn = getConnection();
            //PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String firstName = rs.getString("firstName");
                System.out.println("First name: " + firstName);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
