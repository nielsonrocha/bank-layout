package br.com.nrtec.layout.cef.siacc;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Nielson Rocha
 */
public class DebitoCredito implements  Serializable{
    
    private String cliente;
    private String agencia;
    private String operacao;
    private String conta;
    private String dvConta;
    private Date vencimento;
    private BigDecimal valorDebito;
    private String usoEmpresa;
    private String codigoMovimento;
    private Integer numeroAgendamento;
    private Integer numeroSequencial;

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public BigDecimal getValorDebito() {
        return valorDebito;
    }

    public void setValorDebito(BigDecimal valorDebito) {
        this.valorDebito = valorDebito;
    }

    public String getUsoEmpresa() {
        return usoEmpresa;
    }

    public void setUsoEmpresa(String usoEmpresa) {
        this.usoEmpresa = usoEmpresa;
    }

    public String getCodigoMovimento() {
        return codigoMovimento;
    }

    public void setCodigoMovimento(String codigoMovimento) {
        this.codigoMovimento = codigoMovimento;
    }

    public Integer getNumeroAgendamento() {
        return numeroAgendamento;
    }

    public void setNumeroAgendamento(Integer numeroAgendamento) {
        this.numeroAgendamento = numeroAgendamento;
    }

    public Integer getNumeroSequencial() {
        return numeroSequencial;
    }

    public void setNumeroSequencial(Integer numeroSequencial) {
        this.numeroSequencial = numeroSequencial;
    }

    public String getDvConta() {
        return dvConta;
    }

    public void setDvConta(String dvConta) {
        this.dvConta = dvConta;
    }

    
}
