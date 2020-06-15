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
import model.bean.Pagamento;

public class PagamentoDAO {

    public void create(Pagamento p) {
        Connection con = Conect.getConect();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO Paga(paga_id,valor_conta,parcelamento,usuario, dataPagamento, conta) VALUES(?,?,?,?,?,?) ");
            stmt.setInt(1, p.getIdPagamento());
            stmt.setDouble(2, p.getValorConta());
            stmt.setInt(3, p.getParcelamento());
            stmt.setString(4, p.getNomePagante());
            stmt.setString(5, p.getDataPagamento());
            stmt.setString(6, p.getTipoConta());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar!"+ex);
        }finally{
            Conect.closeConnection(con, stmt);
        }
    }
    
    public List<Pagamento> read() {
        Connection con = Conect.getConect();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pagamento> pagamentos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Paga ");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Pagamento paga = new Pagamento();
                
                paga.setIdPagamento(rs.getInt("paga_id"));
                paga.setValorConta(rs.getDouble("valor_conta"));
                paga.setParcelamento(rs.getInt("parcelamento"));
                paga.setNomePagante(rs.getString("usuario"));
                paga.setDataPagamento(rs.getString("dataPagamento"));
                paga.setTipoConta(rs.getString("conta"));
                pagamentos.add(paga);
            }

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Acessado com sucesso!");
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao acessar os dados!"+ex);
        }finally{
            Conect.closeConnection(con, stmt);
        }
        return pagamentos;
    }
    
    public List<Pagamento> readForDesc(String desc) {
        Connection con = Conect.getConect();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Pagamento> pagamentos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Paga WHERE usuario LIKE ?");
            stmt.setString(1, "%"+desc+"%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Pagamento paga = new Pagamento();
                
                paga.setIdPagamento(rs.getInt("paga_id"));
                paga.setValorConta(rs.getDouble("valor_conta"));
                paga.setParcelamento(rs.getInt("parcelamento"));
                paga.setNomePagante(rs.getString("usuario"));
                paga.setDataPagamento(rs.getString("dataPagamento"));
                paga.setTipoConta(rs.getString("conta"));
                pagamentos.add(paga);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoDAO.class.getName()).log(Level.SEVERE, null, ex);//
        } finally {
            Conect.closeConnection(con, stmt);
        }
        return pagamentos;
    }
    
    public List<Pagamento> readForDescPerfil(String desc) {
        Connection con = Conect.getConect();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Pagamento> pagamentos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Paga WHERE usuario = ?");
            stmt.setString(1, desc);

            rs = stmt.executeQuery();

            while (rs.next()) {

                Pagamento paga = new Pagamento();
                
                paga.setIdPagamento(rs.getInt("paga_id"));
                paga.setValorConta(rs.getDouble("valor_conta"));
                paga.setParcelamento(rs.getInt("parcelamento"));
                paga.setNomePagante(rs.getString("usuario"));
                paga.setDataPagamento(rs.getString("dataPagamento"));
                paga.setTipoConta(rs.getString("conta"));
                pagamentos.add(paga);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoDAO.class.getName()).log(Level.SEVERE, null, ex);//
        } finally {
            Conect.closeConnection(con, stmt);
        }
        return pagamentos;
    }

    public void update(Pagamento p) {
        Connection con = Conect.getConect();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Paga SET valor_conta = ? ,parcelamento = ?,usuario = ?, dataPagamento = ?, conta = ? WHERE paga_id= ?");

            
            stmt.setDouble(1, p.getValorConta());
            stmt.setInt(2, p.getParcelamento());
            stmt.setString(3, p.getNomePagante());
            stmt.setString(4, p.getDataPagamento());
            stmt.setString(5, p.getTipoConta());
            stmt.setInt(6, p.getIdPagamento());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            Conect.closeConnection(con, stmt);
        }
    }
    
    public void delete(Pagamento p) {
        Connection con = Conect.getConect();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM Paga WHERE paga_id = ?");
            stmt.setInt(1, p.getIdPagamento());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            Conect.closeConnection(con, stmt);
        }
    }
}
