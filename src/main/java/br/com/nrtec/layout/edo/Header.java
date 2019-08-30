package br.com.nrtec.layout.edo;

import java.io.Serializable;
import java.util.Date;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;
import org.beanio.builder.Align;

import br.com.nrtec.layout.util.AsciiConstants;
import lombok.Data;

@Data
@Record(minOccurs=1, maxOccurs=1)
@Fields({
    @Field(at=0, name="identificadorDestinatario", length = 20, padding = AsciiConstants.ZERO, rid = true, literal="0"),
    @Field(at=20, name="numeroSequencialIdentificacao", padding = AsciiConstants.ZERO, length = 2, literal="0"),
    @Field(at=22, name="tipoRegistro", length = 1, literal = "0"),
    @Field(at=38, name="nomeArquivo", length = 6, literal = "EDO001"),
    @Field(at=62, name="codigoProduto", length = 5, literal = "00315"),
    @Field(at=67, name="codigoModalidade", length = 5, literal = "1", padding = AsciiConstants.ZERO, align = Align.RIGHT),
    @Field(at=88, name="brancos", length = 12, padding = AsciiConstants.ESPACO_BRANCO),
})
public class Header implements Serializable {

	private static final long serialVersionUID = 1L;

	@Field(at=23, length=4, padding = AsciiConstants.ZERO, align = Align.RIGHT )
	private String agenciaEmpresa;
	
	@Field(at=27, length=11, padding = AsciiConstants.ZERO, align = Align.RIGHT )
	private String contaCorrenteEmpresa;
	
	@Field(at=44, length=12, padding = AsciiConstants.ZERO, align = Align.RIGHT )
	private String numeroContrato;
	
	@Field(at=56, length=6, padding = AsciiConstants.ZERO, align = Align.RIGHT)
	private String numeroRemessa;
	
	@Field(at=72, length=4)
	private String ano;
	
	@Field(at=76, length=2, padding = AsciiConstants.ZERO, align = Align.RIGHT)
	private String mes;
	
	@Field(at=78, length=2, padding = AsciiConstants.ZERO)
	private String remessaExtra = "0";
	
	@Field(at=80, length=8, format="ddMMyyyy")
	private Date dataCredito;
	
}

