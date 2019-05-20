package battleconquer.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getConnetion(){
        Connection connection = null;
        String driverJDBC = "com.mysql.jdbc.Driver";	
        String urlConexao = "jdbc:mysql://localhost/battleConquer";

        String usuarioConexaoBanco  = "root";
        String passwordConexaoBanco  = "";

        try {
            Class.forName(driverJDBC);
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(urlConexao, usuarioConexaoBanco, passwordConexaoBanco);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
