package model.dao;

import connection.Conect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

}
