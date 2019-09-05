package br.com.nrtec.layout.cef.siacc;

import java.io.Serializable;
import java.math.BigDecimal;

import org.beanio.annotation.Record;

import lombok.Data;

/**
 *
 * @author Nielson Rocha
 */
@Data
@Record(minOccurs=1, maxOccurs=1)
public class Trailler implements  Serializable{
    
	private static final long serialVersionUID = 1L;
	private Integer totalRegistros;
    private BigDecimal valorTotal;
    private Integer numeroSequencial;
        
}
