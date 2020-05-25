package model.dao;

import connection.Conect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Usuario;

public class UsuarioDAO {

    public void create(Usuario user) {
        Connection con = Conect.getConect();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO Usuario(nome,telefone,email,endereco,ocupacao,renda,senha) VALUES(?,?,?,?,?,?,?) ");
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getTelefone());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getEndereco());
            stmt.setString(5, user.getOcupacao());
            stmt.setDouble(6, user.getRenda());
            stmt.setString(7, user.getSenha());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar!"+ex);
        
        }finally{
            Conect.closeConnection(con, stmt);
        }

    }

}
