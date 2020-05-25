
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conect {

    public static Connection getConect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/housebills?useTimezone=true&serverTimezone=UTC", "root", "");
            System.out.println("Conectado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao conectar!");
        }
        return conn;

    }

    public static void main(String[] args) {
        Conect.getConect();

    }

    public static void closeConnection(Connection con) {
        if(con!=null){
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt) {
        closeConnection (con);
        if(con!=null){
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        closeConnection(con ,stmt);
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
