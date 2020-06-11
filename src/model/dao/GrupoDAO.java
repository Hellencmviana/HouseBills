package model.dao;

import connection.Conect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Grupo;

public class GrupoDAO {

    public void create(Grupo g) {
        Connection con = Conect.getConect();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO Grupo(idGrupo,nomeGrupo,endereco,telefone) VALUES(?,?,?,?) ");
            stmt.setInt(1, g.getIdGrupo());
            stmt.setString(2, g.getNomeGrupo());
            stmt.setString(3, g.getEndereco());
            stmt.setString(4, g.getTelefone());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar!"+ex);
        
        }finally{
            Conect.closeConnection(con, stmt);
        }

    }
    
    public List<Grupo> read() {
        Connection con = Conect.getConect();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Grupo> grupos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Grupo ");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Grupo g = new Grupo();
                
                g.setIdGrupo(rs.getInt("idGrupo"));
                g.setNomeGrupo(rs.getString("nomeGrupo"));
                g.setEndereco(rs.getString("endereco"));
                g.setTelefone(rs.getString("telefone"));
                grupos.add(g);

            }
            

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Acessado com sucesso!");
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao acessar os dados!"+ex);
        
        }finally{
            Conect.closeConnection(con, stmt);
        }
        return grupos;
    }
    
    public List<Grupo> readForDesc(String desc) {
        Connection con = Conect.getConect();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Grupo> grupos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Grupo WHERE nome LIKE ?");
            stmt.setString(1, "%"+desc+"%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Grupo g = new Grupo();
                
                g.setIdGrupo(rs.getInt("idGrupo"));
                g.setNomeGrupo(rs.getString("nomeGrupo"));
                g.setEndereco(rs.getString("endereco"));
                g.setTelefone(rs.getString("telefone"));
                grupos.add(g);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GrupoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conect.closeConnection(con, stmt);
        }
        return grupos;
    }

    public List<Grupo> readGrupoGetID (String desc){
        Connection con = Conect.getConect();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Grupo> grupos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT idGrupo FROM Grupo WHERE nomeGrupo=? ");
            stmt.setString(1, desc);
            rs= stmt.executeQuery();
            
            while(rs.next()){
                
                Grupo g = new Grupo();
                g.setIdGrupo(rs.getInt("idGrupo"));
                g.setNomeGrupo(rs.getString("nomeGrupo"));
                grupos.add(g); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(GrupoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conect.closeConnection(con, stmt, rs);
        }
        return grupos;   
    }


    public List<Grupo> readGrupoGetDESC (int desc){
        Connection con = Conect.getConect();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Grupo> grupos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT nomeGrupo FROM Grupo WHERE idGrupo=? ");
            stmt.setInt(1, desc);
            rs= stmt.executeQuery();
            
            while(rs.next()){
                
                Grupo g = new Grupo();
                g.setIdGrupo(rs.getInt("idGrupo"));
                g.setNomeGrupo(rs.getString("nomeGrupo"));
                grupos.add(g); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(GrupoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conect.closeConnection(con, stmt, rs);
        }
        return grupos;
    }

    public void update(Grupo g) {
        Connection con = Conect.getConect();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Grupo SET nomeGrupo = ?,endereco = ? WHERE idGrupo= ?");
            stmt.setString(1, g.getNomeGrupo());
            stmt.setString(2, g.getEndereco());
            stmt.setString(3, g.getTelefone());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            Conect.closeConnection(con, stmt);
        }

    }
    
    public void delete(Grupo g) {
        Connection con = Conect.getConect();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM Grupo WHERE idGrupo = ?");
            stmt.setInt(1, g.getIdGrupo());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            Conect.closeConnection(con, stmt);
        }

    }

}
