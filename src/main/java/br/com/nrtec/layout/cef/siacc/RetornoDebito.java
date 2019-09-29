package br.com.nrtec.layout.cef.siacc;

import java.io.Serializable;
import java.math.BigDecimal;

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
	@Field(at=0, name="codigoRegistro", length = 1, literal = "F", rid = true),
	@Field(at=129, name="brancos", length = 20, padding = AsciiConstants.WHITE_SPACE, align = Align.LEFT)
})
public class RetornoDebito implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	@Field(at=1, length=25)
	private String cliente;
    
	@Field(at=26, length=4)
	private String agencia;
    
	@Field(at=30, length=14)
	private String identificacaoClienteBanco;
	
	@Field(at=44, length=8)
    private String vencimento;
	
	@Field(at=52, length=15)
    private BigDecimal valorDebito;
	
	@Field(at=69, length=60)
    private String usoEmpresa;
	
	@Field(at=67, length=2)
    private String codigoRetorno;
	
	@Field(at=149, length=1)
    private String codigoMovimento;

    
}
