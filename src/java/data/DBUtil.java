package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String M_CONN_STRING = "jdbc:mysql://localhost/healthCare?serverTimezone=UTC&noAccessToProcedureBodies=true";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(M_CONN_STRING, USERNAME, PASSWORD);
    }

    public static void processException(SQLException e) {
        System.err.println("Error message: " + e.getMessage());
        System.err.println("Error code: " + e.getErrorCode());
        System.err.println("SQL state: " + e.getSQLState());
    }

    public static void main(String[] args) throws SQLException {
        
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            System.out.println("Connected!");
        } catch (SQLException e) {
            DBUtil.processException(e);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
}
