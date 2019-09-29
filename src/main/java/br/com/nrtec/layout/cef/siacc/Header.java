package br.com.nrtec.layout.cef.siacc;

import java.io.Serializable;
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
@Record(minOccurs=1, maxOccurs=1)
@Fields({
    @Field(at=0, name="codigoRegistro", length = 1, rid = true, literal="A"),
    @Field(at=42, name="codigoBanco", length = 3, literal="104"),
    @Field(at=8, name="tipoCompromisso", length = 2, literal="11"),
    @Field(at=10, name="numeroCompromisso", length = 4, literal="0001"),
    @Field(at=14, name="brancos", length = 8, padding = AsciiConstants.WHITE_SPACE),
    @Field(at=45, name="nomeBanco", length = 20, literal="CAIXA", padding = AsciiConstants.WHITE_SPACE, align = Align.LEFT),
    @Field(at=79, name="versaoLayout", length = 2, literal="04"),
    @Field(at=81, name="identServico", length = 17, literal="DEBITO AUTOMATICO", padding = AsciiConstants.WHITE_SPACE, align = Align.LEFT),
    @Field(at=116, name="filler", length = 27, padding = AsciiConstants.WHITE_SPACE),
    @Field(at=143, name="sequencialRegistro", literal = "000000", length = 6),
    @Field(at=149, name="fillerFuturo", length = 1, padding = AsciiConstants.WHITE_SPACE),
})
public class Header implements Serializable{
    
	private static final long serialVersionUID = 1L;
	
	@Field(at=1, length=1)
	private Integer codigoRemessa;
	
	@Field(at=2, length=6, padding = AsciiConstants.ZERO, align = Align.RIGHT)
    private String codigoConvenio;
    
	@Field(at=22, length=20, padding = AsciiConstants.WHITE_SPACE, align = Align.LEFT)
    private String nomeEmpresa;
    
	@Field(at=65, length=8, format="yyyyMMdd")
    private Date dataMovimento;
    
	@Field(at=73, length=6, padding = AsciiConstants.ZERO, align = Align.RIGHT)
    private String numeroSequencialArquivo;
    
	@Field(at=98, length=4, padding = AsciiConstants.ZERO, align = Align.RIGHT)
    private String agencia;
    
	@Field(at=102, length=3, padding = AsciiConstants.ZERO, align = Align.RIGHT)
    private String operacao;
    
	@Field(at=105, length=8, padding = AsciiConstants.ZERO, align = Align.RIGHT)
    private String conta;
    
	@Field(at=113, length=1)
    private String dvConta;
	
	@Field(at=114, length=1)
	private String ambienteCliente;
	
	@Field(at=115, length=1)
	private String amibenteBanco;
    
}
