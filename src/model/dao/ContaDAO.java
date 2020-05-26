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
                
                Conta conta = new Conta();
                conta.setIdConta(rs.getInt("idConta"));
                conta.setDescricao(rs.getString("descricao"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conect.closeConnection(con, stmt, rs);
        }
        return contas;
        
    }
    
    
}
