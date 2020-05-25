package model.dao;

import connection.Conect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Conta;

public class ContaDAO {

    public void create(Conta user) {
        Connection con = Conect.getConect();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO Conta(descricao,valor,data,juros,pagante) VALUES(?,?,?,?,?) ");
            stmt.setString(1, user.getDescricao());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar!"+ex);
        
        }finally{
            Conect.closeConnection(con, stmt);
        }

    }

}
