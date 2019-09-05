package br.com.nrtec.layout.cef.siacc;

import java.io.Serializable;
import java.math.BigDecimal;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;
import org.beanio.builder.Align;

import br.com.nrtec.layout.util.AsciiConstants;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author Nielson Rocha
 */
@Data
@Builder
@Record(minOccurs=1, maxOccurs=1)
@Fields({
    @Field(at=0, name="codigoRegistro", length = 1, rid = true, literal="Z"),
    @Field(at=24, name="fillerFuturo", length = 119, padding = AsciiConstants.WHITE_SPACE),
    @Field(at=149, name="filler", length = 1, padding = AsciiConstants.WHITE_SPACE),
})
public class Trailler implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	@Field(at=1, length=6, padding = AsciiConstants.ZERO, align = Align.RIGHT)
	private Integer totalRegistros;
    
	@Field(at=7, length=17, format = "#0", padding = AsciiConstants.ZERO, align = Align.RIGHT)
	private BigDecimal valorTotal;
    
	@Field(at=143, length=6, padding = AsciiConstants.ZERO, align = Align.RIGHT)
	private Integer numeroSequencial;
        
}
