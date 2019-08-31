package br.com.nrtec.layout.bancobrasil.edo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;
import org.beanio.builder.Align;

import br.com.nrtec.layout.util.AsciiConstants;
import lombok.Data;

@Data
@Record(minOccurs=1, maxOccurs=-1, order = 1)
@Fields({
	@Field(at=20, name="numeroSequencialIdentificacao", length = 2, literal = "00", rid = true),
	@Field(at=22, name="tipoRegistro", length = 1, literal = "1"),
    @Field(at=92, name="brancos", length = 9, padding = AsciiConstants.WHITE_SPACE)
})
public class Destinatario implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 2.1	Número identificador do destinatário do documento. Preencher com o número em que o destinatário é identificado na empresa conveniada (contracheque: número de inscrição do funcionário na empresa). 
		Este número será o solicitado nos terminais do Banco para emissão do documento
	 */
	@Field(at=0, length=20, padding = AsciiConstants.ZERO, align = Align.RIGHT)
	private String id;
	
	/**
	 * 2.4	Número da agência do destinatário.  Preencher com o número da agência em que o destinatário do documento possui conta (sem dígito verificador)
	 */
	@Field(at=23, length=4, padding = AsciiConstants.ZERO, align = Align.RIGHT)
	private String agencia;
	
	/**
	 * 2.5	Número da conta do destinatário. Preencher com o número da conta do destinatário (sem dígito verificador)
	 */
	@Field(at=27, length=11, padding = AsciiConstants.ZERO, align = Align.RIGHT)
	private String contaCorrente;
	
	/**
	 * 2.6	Quantidade de linhas do documento. Preencher com a quantidade de linhas do documento para o destinatário deste registro (indicador de salto de linha não entra no somatório)
	 */
	@Field(at=38, length=2, padding = AsciiConstants.ZERO, align = Align.RIGHT)
	private Integer quantidadeLinhas;
	
	/**
	 * 2.7	Nome do destinatário. Preencher com o nome do destinatário do documento (contracheque: nome do funcionário da empresa conveniada) 
	 */
	@Field(at=40, length=40, padding = AsciiConstants.WHITE_SPACE, align = Align.LEFT)
	private String nome;
	
	/**
	 * 2.8	CPF. Preencher com o número do CPF do destinatário
	 */
	@Field(at=80, length=11, padding = AsciiConstants.ZERO, align = Align.RIGHT)
	private String cpf;
	
	private List<DadosDocumento> dadosDocumento = new ArrayList<>();
	
	public String getNome() {
		if (StringUtils.isNotBlank(nome) && nome.length() > 40) {
			return nome.substring(0,40);
		}
		return nome;
	}
}
