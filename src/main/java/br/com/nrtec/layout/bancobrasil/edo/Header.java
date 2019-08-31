package br.com.nrtec.layout.bancobrasil.edo;

import java.io.Serializable;
import java.util.Date;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;
import org.beanio.builder.Align;

import br.com.nrtec.layout.util.AsciiConstants;
import lombok.Data;

/**
 * Header para arquivo EDO 001 Banco do Brasil
 * 
 * 
 * @author Nielson Rocha
 *
 */
@Data
@Record(minOccurs=1, maxOccurs=1)
@Fields({
    @Field(at=0, name="identificadorDestinatario", length = 20, padding = AsciiConstants.ZERO, rid = true, literal="0"),
    @Field(at=20, name="numeroSequencialIdentificacao", padding = AsciiConstants.ZERO, length = 2, literal="0"),
    @Field(at=22, name="tipoRegistro", length = 1, literal = "0"),
    @Field(at=38, name="nomeArquivo", length = 6, literal = "EDO001"),
    @Field(at=62, name="codigoProduto", length = 5, literal = "00315"),
    @Field(at=67, name="codigoModalidade", length = 5, literal = "1", padding = AsciiConstants.ZERO, align = Align.RIGHT),
    @Field(at=88, name="brancos", length = 12, padding = AsciiConstants.WHITE_SPACE)
})
public class Header implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * prefixo da agência do BB, sem DV
	 */
	@Field(at=23, length=4, padding = AsciiConstants.ZERO, align = Align.RIGHT )
	private String agenciaEmpresa;
	
	/**
	 * num. da conta da empresa no BB, sem DV 
	 */
	@Field(at=27, length=11, padding = AsciiConstants.ZERO, align = Align.RIGHT )
	private String contaCorrenteEmpresa;
	
	/**
	 * número do contrato, atribuído pelo EDO 
	 */
	@Field(at=44, length=12, padding = AsciiConstants.ZERO, align = Align.RIGHT )
	private String numeroContrato;
	
	/**
	 * número seqüencial da remessa 
	 */
	@Field(at=56, length=6, padding = AsciiConstants.ZERO, align = Align.RIGHT)
	private String numeroRemessa;
	
	/**
	 * ano a que se refere o documento 
	 */
	@Field(at=72, length=4)
	private String ano;
	
	/**
	 * mês a que se refere o documento 
	 */
	@Field(at=76, length=2, padding = AsciiConstants.ZERO, align = Align.RIGHT)
	private String mes;
	
	/**
	 * número seqüencial de extraordinariedade 
	 */
	@Field(at=78, length=2, padding = AsciiConstants.ZERO)
	private String remessaExtra = "0";
	
	/**
	 * data (ddmmaaaa) referente ao crédito 
	 */
	@Field(at=80, length=8, format="ddMMyyyy")
	private Date dataCredito;
	
}

