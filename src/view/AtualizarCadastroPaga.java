/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Pagamento;
import model.dao.PagamentoDAO;
/**
 *
 * @author Usuário
 */
public class AtualizarCadastroPaga extends javax.swing.JFrame {

    /**
     * Creates new form AtualizarCadastroPaga
     */
    public AtualizarCadastroPaga() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTPagamentos.getModel();
        jTPagamentos.setRowSorter(new TableRowSorter(modelo));
        
        readJTable();
    }
    
    public void readJTable() {
        
        DefaultTableModel modelo = (DefaultTableModel) jTPagamentos.getModel();
        modelo.setNumRows(0);
        PagamentoDAO pdao = new PagamentoDAO();

        for(Pagamento p : pdao.read()) {

            modelo.addRow(new Object[]{
                p.getIdPagamento(),
                p.getValorConta(),
                p.getParcelamento(),
                p.getNomePagante(),
                p.getDataPagamento(),
                p.getTipoConta()
            });
        }
    }

    public void readTableForDesc (String desc){
        
        DefaultTableModel modelo = (DefaultTableModel) jTPagamentos.getModel();
        modelo.setNumRows(0);
        PagamentoDAO pdao = new PagamentoDAO();

        for(Pagamento p : pdao.readForDesc(desc)){
            modelo.addRow(new Object[]{
                p.getIdPagamento(),
                p.getValorConta(),
                p.getParcelamento(),
                p.getNomePagante(),
                p.getDataPagamento(),
                p.getTipoConta()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jValorConta = new javax.swing.JTextField();
        jParcelamento = new javax.swing.JTextField();
        jPagante = new javax.swing.JTextField();
        jDataPagamento = new javax.swing.JTextField();
        jDescricaoConta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTPagamentos = new javax.swing.JTable();
        txtBuscaDesc = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Atualizar Despesas");

        jValorConta.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N

        jParcelamento.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N

        jPagante.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jPagante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPaganteActionPerformed(evt);
            }
        });

        jDataPagamento.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N

        jDescricaoConta.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jDescricaoConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDescricaoContaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Valor da conta:");

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("Parcelamento:");

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setText("Pagante:");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Data do pagamento:");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Tipo da conta:");

        jTPagamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Valor da conta ", "Parcelamento ", "Usuario", "Data Pagamento ", "Tipo de conta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTPagamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTPagamentosMouseClicked(evt);
            }
        });
        jTPagamentos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTPagamentosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTPagamentos);

        txtBuscaDesc.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        txtBuscaDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaDescActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jButton3.setText("Excluir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jButton1.setText("Atualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu6.setText("Voltar");
        jMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu6ActionPerformed(evt);
            }
        });
        jMenuBar2.add(jMenu6);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel11)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(4, 4, 4)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDescricaoConta, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPagante, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jParcelamento, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jValorConta, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscaDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jValorConta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jParcelamento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPagante, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jDataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jDescricaoConta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscaDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPaganteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPaganteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPaganteActionPerformed

    private void jDescricaoContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDescricaoContaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jDescricaoContaActionPerformed

    private void txtBuscaDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaDescActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        readTableForDesc(txtBuscaDesc.getText());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (jTPagamentos.getSelectedRow() != -1) {

            Pagamento p = new Pagamento();
            PagamentoDAO dao = new PagamentoDAO();

            p.setIdPagamento((int) jTPagamentos.getValueAt(jTPagamentos.getSelectedRow(), 0));

            dao.delete(p);
            
            jValorConta.setText("");
            jParcelamento.setText("");
            jPagante.setText("");
            jDataPagamento.setText("");
            jDescricaoConta.setText("");

            readJTable();

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um pagamento para excluir.");
        }
    }//GEN-LAST:event_jButton3ActionPerformed
 
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        if (jTPagamentos.getSelectedRow() != -1) {
            Pagamento paga = new Pagamento();
            PagamentoDAO dao = new PagamentoDAO();

            paga.setValorConta(Double.parseDouble(jValorConta.getText()));
            paga.setParcelamento(Integer.parseInt(jParcelamento.getText()));
            paga.setNomePagante(jPagante.getText());
            paga.setDataPagamento(jDataPagamento.getText());
            paga.setTipoConta(jDescricaoConta.getText());
            paga.setIdPagamento((int) jTPagamentos.getValueAt(jTPagamentos.getSelectedRow(), 0));
            dao.update(paga);

            jValorConta.setText("");
            jParcelamento.setText("");
            jPagante.setText("");
            jDataPagamento.setText("");
            jDescricaoConta.setText("");

            readJTable();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um pagamento para atualizar.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTPagamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPagamentosMouseClicked
        // TODO add your handling code here:
        
        if (jTPagamentos.getSelectedRow() != -1) {

            jValorConta.setText(jTPagamentos.getValueAt(jTPagamentos.getSelectedRow(), 1).toString());
            jParcelamento.setText(jTPagamentos.getValueAt(jTPagamentos.getSelectedRow(), 2).toString());
            jPagante.setText(jTPagamentos.getValueAt(jTPagamentos.getSelectedRow(), 3).toString());
            jDataPagamento.setText(jTPagamentos.getValueAt(jTPagamentos.getSelectedRow(), 4).toString());
            jDescricaoConta.setText(jTPagamentos.getValueAt(jTPagamentos.getSelectedRow(), 5).toString());
        }
    }//GEN-LAST:event_jTPagamentosMouseClicked

    private void jTPagamentosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPagamentosKeyReleased
        // TODO add your handling code here:
        
        if (jTPagamentos.getSelectedRow() != -1) {

            jValorConta.setText(jTPagamentos.getValueAt(jTPagamentos.getSelectedRow(), 1).toString());
            jParcelamento.setText(jTPagamentos.getValueAt(jTPagamentos.getSelectedRow(), 2).toString());
            jPagante.setText(jTPagamentos.getValueAt(jTPagamentos.getSelectedRow(), 3).toString());
            jDataPagamento.setText(jTPagamentos.getValueAt(jTPagamentos.getSelectedRow(), 4).toString());
            jDescricaoConta.setText(jTPagamentos.getValueAt(jTPagamentos.getSelectedRow(), 5).toString());
        }
    }//GEN-LAST:event_jTPagamentosKeyReleased

    private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6ActionPerformed
        // TODO add your handling code here:
        ContasGrupoPerfil tela = new ContasGrupoPerfil();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AtualizarCadastroPaga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtualizarCadastroPaga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtualizarCadastroPaga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtualizarCadastroPaga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AtualizarCadastroPaga().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JTextField jDataPagamento;
    private javax.swing.JTextField jDescricaoConta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JTextField jPagante;
    private javax.swing.JTextField jParcelamento;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTPagamentos;
    private javax.swing.JTextField jValorConta;
    private javax.swing.JTextField txtBuscaDesc;
    // End of variables declaration//GEN-END:variables
}
