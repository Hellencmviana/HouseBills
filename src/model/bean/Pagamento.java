package model.bean;
import model.bean.Usuario;
import model.bean.Grupo;
import model.bean.Conta;

public class Pagamento {
    String data, dataPagamento, dataVencimento;
    Double valorConta, valorPago, juros;
    int parcelamento, idPagamento;
    Usuario idPagante;
    Grupo idGrupo;
    Conta idConta;
    
    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }
    
    public Usuario getIdPagante(){
        return idPagante;
    }
    
    public void setIdPagante(Usuario idPagante){
        this.idPagante = idPagante;
    }
    
    public Grupo getIdGrupo(){
        return idGrupo;
    }
    
    public void setIdGrupo(Grupo idGrupo){
        this.idGrupo = idGrupo;
    }
    
    public Conta getIdConta(){
        return idConta;
    }
    
    public void setIdConta(Conta idConta){
        this.idConta = idConta;
    }
    
    public Double getValorConta(){
        return valorConta;
    }
    
    public void setValorConta(Double valorConta){
        this.valorConta = valorConta;
    }

    public Double getValorPago(){
        return valorPago;
    }
    
    public void setValorPago(Double valorPago){
        this.valorPago = valorPago;
    }

    public int getParcelamento(){
        return parcelamento;
    }
    
    public void setParcelamento(int parcelamento){
        this.parcelamento = parcelamento;
    }
    
    public String getDataPagamento() {
        return dataPagamento;
    }
    
    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    
    public String getDataVencimento() {
        return dataVencimento;
    }
    
    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    
    public Double getJuros(){
        return juros;
    }
    
    public void setJuros(Double juros){
        this.juros = juros;
    }
    
}
