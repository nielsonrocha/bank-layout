import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.beanio.BeanWriter;
import org.beanio.StreamFactory;
import org.beanio.builder.FixedLengthParserBuilder;
import org.beanio.builder.GroupBuilder;
import org.beanio.builder.StreamBuilder;

import br.com.nrtec.layout.bancobrasil.edo.DadosDocumento;
import br.com.nrtec.layout.bancobrasil.edo.Destinatario;
import br.com.nrtec.layout.bancobrasil.edo.Header;
import br.com.nrtec.layout.bancobrasil.edo.Trailler;

public class LayoutEDOTest {

	public void testeEDO() {

		StreamFactory factory = StreamFactory.newInstance();

		StreamBuilder builderTxt = new StreamBuilder("layoutEDO").format("fixedlength")
				.parser(new FixedLengthParserBuilder())
				.addRecord(br.com.nrtec.layout.bancobrasil.edo.Header.class)
				.addGroup(new GroupBuilder("Destinatario")
						.addRecord(br.com.nrtec.layout.bancobrasil.edo.Destinatario.class)
						.addRecord(br.com.nrtec.layout.bancobrasil.edo.DadosDocumento.class))
				.addRecord(br.com.nrtec.layout.bancobrasil.edo.Trailler.class);
		
		factory.define(builderTxt);

		BeanWriter out = factory.createWriter("layoutEDO", new File("c:\\temp\\edo.txt"));

		Header header = new Header();

		header.setAgenciaEmpresa("3846");
		header.setAno("2019");
		header.setMes("8");
		header.setContaCorrenteEmpresa("234361");
		header.setDataCredito(new Date());
		header.setNumeroContrato("987");
		header.setNumeroRemessa("123");
		
		List<Destinatario> destinatarios = new ArrayList<>();

		Destinatario dest = new Destinatario();
		dest.setAgencia("0528");
		dest.setContaCorrente("41470");
		dest.setCpf("03499315360");
		dest.setId("0082142000");
		dest.setNome("JOSE JOAO DA SILVA");

		dest.getDadosDocumento().add(new DadosDocumento("0082142000", 1, "SALARIO BASE 1.000,00", 0));
		dest.getDadosDocumento().add(new DadosDocumento("0082142000", 2, "DESCONTOS      300,00", 0));
		dest.getDadosDocumento().add(new DadosDocumento("0082142000", 3, "LIQUIDO        700,00", 0));

		dest.setQuantidadeLinhas(dest.getDadosDocumento().size());
		
		destinatarios.add(dest);

		dest = new Destinatario();
		dest.setAgencia("1234");
		dest.setContaCorrente("56789");
		dest.setCpf("12345678900");
		dest.setId("0081032000");
		dest.setNome("TESTE DE FUNCIONARIO");

		dest.getDadosDocumento().add(new DadosDocumento("0081032000", 1, "SALARIO BASE 2.000,00", 0));
		dest.getDadosDocumento().add(new DadosDocumento("0081032000", 2, "DESCONTOS      900,00", 0));
		dest.getDadosDocumento().add(new DadosDocumento("0081032000", 3, "LIQUIDO      1.100,00", 0));

		dest.setQuantidadeLinhas(dest.getDadosDocumento().size());
		
		destinatarios.add(dest);
		
		// gerando arquivo
		out.write(header); // gravar header
		
		destinatarios.forEach(destinatario -> {
			
			out.write(destinatario); // gravar destinatario
			destinatario.getDadosDocumento().forEach(d -> {
				out.write(d); // gravar detalhe do destinatario
			});

		});

		Trailler trailler = new Trailler();
		trailler.setQuantidadeDestinatario(destinatarios.size());

		out.write(trailler);

		out.flush();
		out.close();
	}
}
