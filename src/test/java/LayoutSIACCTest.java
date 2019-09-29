import java.io.File;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.beanio.BeanReader;
import org.beanio.BeanWriter;
import org.beanio.StreamFactory;
import org.beanio.builder.FixedLengthParserBuilder;
import org.beanio.builder.StreamBuilder;

import br.com.nrtec.layout.cef.siacc.Constantes;
import br.com.nrtec.layout.cef.siacc.DebitoCredito;
import br.com.nrtec.layout.cef.siacc.Header;
import br.com.nrtec.layout.cef.siacc.Trailler;


public class LayoutSIACCTest {
	
	public void testeLeitura() {
		StreamFactory factory = StreamFactory.newInstance();
		
		StreamBuilder builderTxt = new StreamBuilder("layoutSIACC").format("fixedlength")
				.parser(new FixedLengthParserBuilder())
				.addRecord(br.com.nrtec.layout.cef.siacc.Header.class)
				.addRecord(br.com.nrtec.layout.cef.siacc.DebitoCredito.class)
				.addRecord(br.com.nrtec.layout.cef.siacc.RetornoDebito.class)
				.addRecord(br.com.nrtec.layout.cef.siacc.Trailler.class);
				
		
		factory.define(builderTxt);
		
		BeanReader in = factory.createReader("layoutSIACC", new File("c:\\temp\\retorno\\03091901.RET"));
		
		Object record = null;
		
		while ((record = in.read()) != null) {
			System.out.println(record);
		}
	}

	public static void main(String...args) {

		StreamFactory factory = StreamFactory.newInstance();

		StreamBuilder builderTxt = new StreamBuilder("layoutSIACC").format("fixedlength")
				.parser(new FixedLengthParserBuilder())
				.addRecord(br.com.nrtec.layout.cef.siacc.Header.class)
				.addRecord(br.com.nrtec.layout.cef.siacc.DebitoCredito.class)
				.addRecord(br.com.nrtec.layout.cef.siacc.Trailler.class);
				
		
		factory.define(builderTxt);

		BeanWriter out = factory.createWriter("layoutSIACC", new File("c:\\temp\\REM000782.REM"));
		
		Header h = new Header();
		h.setAgencia("1413");
		h.setAmbienteCliente("P");
		h.setAmibenteBanco("P");
		h.setCodigoConvenio("183636");
		h.setCodigoRemessa(Constantes.REMESSA);
		h.setConta("085");
		h.setDataMovimento(new Date());
		h.setDvConta("2");
		h.setNomeEmpresa("APCEF DEBITO EM CONT");
		h.setNumeroSequencialArquivo("782");
		h.setOperacao("003");
		
		out.write(h);
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 16);
		
		DebitoCredito debito = new DebitoCredito();
		debito.setAgencia("1739");
		debito.setCliente("0043135500");
		debito.setCodigoMovimento("0");
		debito.setConta("00003516");
		debito.setDvConta("4");
		debito.setNumeroAgendamento(1);
		debito.setNumeroSequencial(1);
		debito.setOperacao("001");
		debito.setUsoEmpresa("9900266348");
		debito.setValorDebito(new BigDecimal(5.00 * 100));
		debito.setVencimento(c.getTime());
		
		out.write(debito);
		
		Trailler t = new Trailler();
				t.setNumeroSequencial(2);
				t.setTotalRegistros(3);
				t.setValorTotal(new BigDecimal(5.00 * 100));
		
		out.write(t);
				
		out.flush();
		out.close();

		/*Header header = Header.builder()
				.agencia("1405")
				.ambienteCliente("P")
				.amibenteBanco("P")
				.codigoConvenio("123456")
				.codigoRemessa(1)
				.conta("30")
				.dataMovimento(new Date())
				.dvConta("1")
				.nomeEmpresa("EMPRESA TESTE")
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
				.valorDebito(BigDecimal.ZERO)
				.numeroAgendamento(1)
				.numeroSequencial(1)
				.operacao("001")
				.usoEmpresa("C0000650838")
				.build();

		out.write(debito);
		
		Trailler t = Trailler.builder()
				.numeroSequencial(2)
				.totalRegistros(1)
				.valorTotal(BigDecimal.ZERO)
				.build();
		
		out.write(t);
		
		out.flush();
		out.close();*/
	}
}
