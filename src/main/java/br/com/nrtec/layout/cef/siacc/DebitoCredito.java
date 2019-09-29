package br.com.nrtec.layout.cef.siacc;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;
import org.beanio.builder.Align;

import br.com.nrtec.layout.util.AsciiConstants;
import lombok.Data;

/**
 *
 * @author Nielson Rocha
 */
@Data
@Record(minOccurs=-1, maxOccurs=-1)
@Fields({
	@Field(at=0, name="codigoRegistro", length = 1, literal = "E", rid = true),
	@Field(at=135, name="brancos", length = 2, padding = AsciiConstants.WHITE_SPACE, align = Align.LEFT),
	@Field(at=67, name="codigoMoeda", length = 2, literal = "03"),
})
public class DebitoCredito implements  Serializable{
    
	private static final long serialVersionUID = 1L;
	
	@Field(at=1, length = 25, padding = AsciiConstants.WHITE_SPACE, align = Align.LEFT)
	private String cliente;
    
	@Field(at=26, length = 4, padding = AsciiConstants.ZERO, align = Align.RIGHT)
	private String agencia;
	
	@Field(at=30, length = 3, padding = AsciiConstants.ZERO, align = Align.RIGHT)
	private String operacao;
    
	@Field(at=33, length = 8, padding = AsciiConstants.ZERO, align = Align.RIGHT)
	private String conta;
    
	@Field(at=41, length = 1)
	private String dvConta;
    
	@Field(at=44, length = 8, format = "yyyyMMdd")
	private Date vencimento;
    
	@Field(at=52, length = 15, format = "#0", padding = AsciiConstants.ZERO, align = Align.RIGHT)
	private BigDecimal valorDebito;
    
	@Field(at=69, length = 60, padding = AsciiConstants.WHITE_SPACE, align = Align.LEFT)
	private String usoEmpresa;
    
	@Field(at=149, length = 1)
	private String codigoMovimento;
    
	@Field(at=129, length = 6, padding = AsciiConstants.ZERO, align = Align.RIGHT)
	private Integer numeroAgendamento;
    
	@Field(at=143, length = 6, padding = AsciiConstants.ZERO, align = Align.RIGHT)
	private Integer numeroSequencial;

}
