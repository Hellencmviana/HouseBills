package model.dao;

import connection.Conect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Usuario;
import java.util.*;

public class UsuarioDAO {

    public void create(Usuario user) {
        Connection con = Conect.getConect();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO Usuario(idUsuario,nome,telefone,email,endereco,ocupacao,renda,senha) VALUES(?,?,?,?,?,?,?,?) ");
            stmt.setInt(1, user.getIdUsuario());
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

    public List<Usuario> read() {
        Connection con = Conect.getConect();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Usuario ");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Usuario usuario = new Usuario();
                
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setEmail(rs.getString("email"));
                usuario.setEndereco(rs.getString("endereco"));
                usuario.setOcupacao(rs.getString("ocupacao"));
                usuario.setRenda(rs.getDouble("renda"));
                usuario.setSenha(rs.getString("senha"));
                usuarios.add(usuario);
            }
            

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Acessado com sucesso!");
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao acessar os dados!"+ex);
        
        }finally{
            Conect.closeConnection(con, stmt);
        }
        return usuarios;
    }
    
    public List<Usuario> readForDesc(String desc) {
        Connection con = Conect.getConect();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuario> usuarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Usuario WHERE nome LIKE ?");
            stmt.setString(1, "%"+desc+"%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Usuario usuario = new Usuario();
                
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setEmail(rs.getString("email"));
                usuario.setEndereco(rs.getString("endereco"));
                usuario.setOcupacao(rs.getString("ocupacao"));
                usuario.setRenda(rs.getDouble("renda"));
                usuario.setSenha(rs.getString("senha"));
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conect.closeConnection(con, stmt);
        }

        return usuarios;

    }

    public void update(Usuario user) {
        Connection con = Conect.getConect();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Usuario SET nome = ? ,telefone = ?,email = ?, endereco = ?, ocupacao = ?, senha = ? WHERE idUsuario= ?");
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getTelefone());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getEndereco());
            stmt.setString(5, user.getOcupacao());
            stmt.setDouble(6, user.getRenda());
            stmt.setString(7, user.getSenha());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            Conect.closeConnection(con, stmt);
        }

    }
    
    public void delete(Usuario user) {
        Connection con = Conect.getConect();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM Usuario WHERE id = ?");
            stmt.setInt(1, user.getIdUsuario());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            Conect.closeConnection(con, stmt);
        }

    }
    
    public boolean checkLogin(String login, String senha) {

        Connection con = Conect.getConect();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            stmt = con.prepareStatement("SELECT * FROM Usuario WHERE telefone = ? and senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {

                
                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conect.closeConnection(con, stmt);
        }

        return check;

    }

}
