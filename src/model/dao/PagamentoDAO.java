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
            stmt = con.prepareStatement("INSERT INTO Paga(pagante,grupo,descricaoConta,valorConta,valorPago,parcelamento,dataPagamento,dataVencimento,juros) VALUES(?,?,?,?,?,?,?,?,?) ");
            stmt.setString(1, user.getPagante());
            stmt.setString(2, user.getGrupo());
            stmt.setString(3, user.getConta());
            stmt.setDouble(4, user.getValorConta());
            stmt.setDouble(5, user.getValorPago());
            stmt.setInt(6, user.getParcelamento());
            stmt.setString(7, user.getDataPagamento());
            stmt.setString(8, user.getDataVencimento());
            stmt.setDouble(9, user.getJuros());


            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar!"+ex);
        
        }finally{
            Conect.closeConnection(con, stmt);
        }

    }

}
