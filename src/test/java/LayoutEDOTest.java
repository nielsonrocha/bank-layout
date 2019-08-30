import java.io.File;
import java.util.Date;

import org.beanio.BeanWriter;
import org.beanio.StreamFactory;
import org.beanio.builder.FixedLengthParserBuilder;
import org.beanio.builder.StreamBuilder;

import br.com.nrtec.layout.edo.Header;

public class LayoutEDOTest {

	public static void main(String[] args) throws Exception {
		// create a BeanIO StreamFactory
        StreamFactory factory = StreamFactory.newInstance();
        
        StreamBuilder builderTxt = new StreamBuilder("layoutEDO")
                .format("fixedlength")
                .parser(new FixedLengthParserBuilder())
                .addRecord(br.com.nrtec.layout.edo.Header.class);
        factory.define(builderTxt);
        
        // create a BeanWriter to write to "output.csv"
        BeanWriter out = factory.createWriter("layoutEDO", new File("c:\\temp\\edo.txt"));        
        
        Header header = new Header();
        
        header.setAgenciaEmpresa("3846");
        header.setAno("2019");
        header.setMes("5");
        header.setContaCorrenteEmpresa("111361");
        header.setDataCredito(new Date());
        header.setNumeroContrato("877");
        header.setNumeroRemessa("849");
        
        
        out.write(header);
        
        out.flush();
        out.close();
	}
}
