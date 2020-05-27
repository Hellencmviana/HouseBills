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
import model.bean.Conta;
import model.bean.Grupo;

public class ContaDAO {

    public void create(Conta c) {
        Connection con = Conect.getConect();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO Conta(idConta, descricao) VALUES(?,?) ");
            stmt.setInt(1, c.getIdConta());
            stmt.setString(2, c.getDescricao());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar!"+ex);
        
        }finally{
            Conect.closeConnection(con, stmt);
        }

    }
    
    public List<Conta> read() {
        Connection con = Conect.getConect();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Conta> contas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Conta ");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Conta c = new Conta();
                
                c.setIdConta(rs.getInt("idConta"));
                c.setDescricao(rs.getString("descricao"));
                contas.add(c);

            }
            

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Acessado com sucesso!");
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao acessar os dados!"+ex);
        
        }finally{
            Conect.closeConnection(con, stmt);
        }
        return contas;
    }

    public List<Conta> readForDesc (String desc){
        Connection con = Conect.getConect();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Conta> contas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Conta WHERE descricao LIKE ? ");
            stmt.setString(1, "%"+desc+"%");
            rs= stmt.executeQuery();
            
            while(rs.next()){
                
                Conta c = new Conta();
                c.setIdConta(rs.getInt("idConta"));
                c.setDescricao(rs.getString("descricao"));
                contas.add(c);

                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conect.closeConnection(con, stmt, rs);
        }
        return contas;
        
    }
    
    public void update(Conta c) {
        Connection con = Conect.getConect();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Conta SET descricao = ? WHERE idConta= ?");
            stmt.setString(1, c.getDescricao());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            Conect.closeConnection(con, stmt);
        }

    }
    
    public void delete(Conta c) {
        Connection con = Conect.getConect();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM Conta WHERE idConta = ?");
            stmt.setInt(1, c.getIdConta());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            Conect.closeConnection(con, stmt);
        }

    }
}
