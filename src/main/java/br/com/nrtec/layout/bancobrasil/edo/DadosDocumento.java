package br.com.nrtec.layout.bancobrasil.edo;

import java.io.Serializable;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;
import org.beanio.builder.Align;

import br.com.nrtec.layout.util.AsciiConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Record(minOccurs=1, maxOccurs=-1, order = 2)
@Fields({
	@Field(at=22, name="tipoRegistro", length = 1, literal = "2", rid = true),
    @Field(at=72, name="brancos", length = 28, padding = AsciiConstants.WHITE_SPACE)
})
public class DadosDocumento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 3.1	Número identificador do destinatário do documento. Preencher com o número em que o destinatário é identificado na empresa conveniada (contracheque: número de inscrição do funcionário na empresa). 
		Este número será o solicitado nos terminais do Banco para emissão do documento
	 */
	@Field(at=0, length=20, padding = AsciiConstants.ZERO, align = Align.RIGHT)
	private String id;

	/**
	 * 3.2	Número seqüencial de identificação da linha do documento. Preencher com o número da linha do texto (número seqüencial)
	 */
	@Field(at=20, length=2, padding = AsciiConstants.ZERO, align = Align.RIGHT)
	private Integer numeroLinha;
	
	/**
	 *  3.4	Texto do documento. Preencher com o texto que comporá a linha do documento. Tudo o que constar neste campo é o que será impresso para o cliente. O Banco não insere nenhuma informação no texto, tal como nome da empresa, a identificação do funcionário, etc
	 */
	@Field(at=23, length=48, padding = AsciiConstants.WHITE_SPACE, align = Align.LEFT)
	private String textoDocumento;
	
	/**
	 * 3.5	Indicador de salto de linha. Preencher zero (0) para linhas corridas (uma em baixo da outra) ou um (1) para saltar uma linha (a linha seguinte a do registro com indicador de salto igual a “1” será toda preenchida com brancos)
	 */
	@Field(at=71, length=1, padding = AsciiConstants.ZERO, align = Align.LEFT)
	private Integer saltoLinha;
}
