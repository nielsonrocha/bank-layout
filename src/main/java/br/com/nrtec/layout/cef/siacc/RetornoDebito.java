package br.com.nrtec.layout.cef.siacc;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.beanio.annotation.Record;

import lombok.Data;

/**
 *
 * @author Nielson Rocha
 */
@Data
@Record(minOccurs=1, maxOccurs=1)
public class RetornoDebito implements Serializable {
    
	private static final long serialVersionUID = 1L;
	private String cliente;
    private String agencia;
    private String operacao;
    private String conta;
    private String dvConta;
    private Date vencimento;
    private BigDecimal valorDebito;
    private String usoEmpresa;
    private String codigoRetorno;
    private String codigoMovimento;

    
}
