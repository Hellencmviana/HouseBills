package model.dao;

import connection.Conect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Pagamento;

public class PagamentoDAO {

    public void create(Pagamento user) {
        Connection con = Conect.getConect();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO Pagamento(valorPagamento,parcelamento,pagante,dataPagamento) VALUES(?,?,?,?) ");
            stmt.setDouble(1, user.getValorPagamento());
            stmt.setDouble(2, user.getParcelamento());
            stmt.setString(3, user.getPagante());
            stmt.setString(4, user.getdataPagamento());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar!"+ex);
        
        }finally{
            Conect.closeConnection(con, stmt);
        }

    }

}
