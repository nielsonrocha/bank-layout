import java.io.File;
import java.math.BigDecimal;
import java.util.Date;

import org.beanio.BeanWriter;
import org.beanio.StreamFactory;
import org.beanio.builder.FixedLengthParserBuilder;
import org.beanio.builder.StreamBuilder;

import br.com.nrtec.layout.cef.siacc.DebitoCredito;
import br.com.nrtec.layout.cef.siacc.Header;


public class LayoutSIACCTest {

	public static void main(String[] args) throws Exception {

		StreamFactory factory = StreamFactory.newInstance();

		StreamBuilder builderTxt = new StreamBuilder("layoutSIACC").format("fixedlength")
				.parser(new FixedLengthParserBuilder())
				.addRecord(br.com.nrtec.layout.cef.siacc.Header.class)
				.addRecord(br.com.nrtec.layout.cef.siacc.DebitoCredito.class);
				
		
		factory.define(builderTxt);

		BeanWriter out = factory.createWriter("layoutSIACC", new File("c:\\temp\\siacc.txt"));

		Header header = Header.builder()
				.agencia("1405")
				.ambienteCliente("P")
				.amibenteBanco("P")
				.codigoConvenio("339390")
				.codigoRemessa(1)
				.conta("30")
				.dataMovimento(new Date())
				.dvConta("1")
				.nomeEmpresa("SITRAJUFE MA")
				.numeroSequencialArquivo("1")
				.operacao("003")
				.build();

		out.write(header);
		
		DebitoCredito debito = DebitoCredito.builder()
				.agencia("1521")
				.cliente("0065083800")
				.codigoMovimento("5")
				.conta("8333")
				.dvConta("3")
				.vencimento(new Date())
				.valorDebito(BigDecimal.valueOf(1234.46 * 100))
				.numeroAgendamento(1)
				.numeroSequencial(1)
				.operacao("001")
				.usoEmpresa("C0000650838")
				.build();

		out.write(debito);
		
		out.flush();
		out.close();
	}
}
