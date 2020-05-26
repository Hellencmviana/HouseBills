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
import model.bean.Usuario;

public class PagamentoDAO {

    public void create(Pagamento p) {
        Connection con = Conect.getConect();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO Paga(paga_id,pagante,grupo,descricaoConta,valorConta,valorPago,parcelamento,dataPagamento,dataVencimento,juros) VALUES(?,?,?,?,?,?,?,?,?,?) ");
            stmt.setInt(1, p.getIdPagamento());
            stmt.setInt(2, p.getIdPagante());
            stmt.setInt(3, p.getIdGrupo());
            stmt.setInt(4, p.getIdConta());
            stmt.setDouble(5, p.getValorConta());
            stmt.setDouble(6, p.getValorPago());
            stmt.setInt(7, p.getParcelamento());
            stmt.setString(8, p.getDataPagamento());
            stmt.setString(9, p.getDataVencimento());
            stmt.setDouble(10, p.getJuros());


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
                paga.setIdPagante(rs.getInt("id_usuario"));
                paga.setIdGrupo(rs.getInt("grupo_id"));
                paga.setIdConta(rs.getInt("conta_id"));
                paga.setValorConta(rs.getDouble("valor_conta"));
                paga.setValorPago(rs.getDouble("valor_pago"));
                paga.setParcelamento(rs.getInt("parcelamento"));
                paga.setDataPagamento(rs.getString("data_pagamento"));
                paga.setDataVencimento(rs.getString("data_vencimento"));
                paga.setJuros(rs.getDouble("juros"));
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
            stmt = con.prepareStatement("SELECT * FROM Paga WHERE nome LIKE ?");
            stmt.setString(1, "%"+desc+"%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Pagamento paga = new Pagamento();
                
                paga.setIdPagamento(rs.getInt("paga_id"));
                paga.setIdPagante(rs.getInt("id_usuario"));
                paga.setIdGrupo(rs.getInt("grupo_id"));
                paga.setIdConta(rs.getInt("conta_id"));
                paga.setValorConta(rs.getDouble("valor_conta"));
                paga.setValorPago(rs.getDouble("valor_pago"));
                paga.setParcelamento(rs.getInt("parcelamento"));
                paga.setDataPagamento(rs.getString("data_pagamento"));
                paga.setDataVencimento(rs.getString("data_vencimento"));
                paga.setJuros(rs.getDouble("juros"));
                pagamentos.add(paga);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conect.closeConnection(con, stmt);
        }

        return pagamentos;

    }

    public void update(Pagamento p) {
        Connection con = Conect.getConect();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Paga SET id_usuario = ? ,grupo_id = ?,conta_id = ?, valor_conta = ?, valor_pago = ?, parcelamento = ?, data_pagamento = ?, data_vencimento = ?, juros = ? WHERE paga_id= ?");
            stmt.setInt(1, p.getIdPagante());
            stmt.setInt(2, p.getIdGrupo());
            stmt.setInt(3, p.getIdConta());
            stmt.setDouble(4, p.getValorConta());
            stmt.setDouble(5, p.getValorPago());
            stmt.setInt(6, p.getParcelamento());
            stmt.setString(7, p.getDataPagamento());
            stmt.setString(8, p.getDataVencimento());
            stmt.setDouble(9, p.getJuros());

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
            stmt = con.prepareStatement("DELETE FROM Paga WHERE id = ?");
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
