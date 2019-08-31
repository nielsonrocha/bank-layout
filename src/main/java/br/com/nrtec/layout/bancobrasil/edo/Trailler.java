package br.com.nrtec.layout.bancobrasil.edo;

import java.io.Serializable;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;
import org.beanio.builder.Align;

import br.com.nrtec.layout.util.AsciiConstants;
import lombok.Data;

@Data
@Record(minOccurs=1, maxOccurs=1)
@Fields({
    @Field(at=0, name="identificador", length = 20, rid = true, literal="99999999999999999999"),
    @Field(at=20, name="sequencial", length = 2, literal="99"),
    @Field(at=22, name="tipoRegistro", length = 1, literal = "9"),
    @Field(at=23, name="agenciaConta", length = 15, literal = "999999999999999"),
    @Field(at=49, name="brancos", length = 51, padding = AsciiConstants.WHITE_SPACE)
})
public class Trailler implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Field(at=38, length = 11, padding = AsciiConstants.ZERO, align = Align.RIGHT)
	private Integer quantidadeDestinatario;
}
