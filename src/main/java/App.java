import no.edipost.integration.client.domain.Consignee;
import no.edipost.integration.client.domain.Consignment;
import no.edipost.integration.client.domain.Consignor;
import no.edipost.integration.client.domain.Item;
import no.edipost.integration.client.service.DefaultEdipostService;
import no.edipost.integration.client.service.EdipostService;
import no.edipost.integration.client.utilities.FileUtilities;
import org.apache.pdfbox.pdmodel.PDDocument;
import javax.print.PrintService;
import java.awt.print.PrinterJob;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;


/**
 * Hello world!
 */
public class App {
	public static void main( String[] args ) {
		
		// -- Connect to service
		EdipostService service = new DefaultEdipostService( "http://localhost:2847/edipost-integration", "f666b087a3bf58ef24082882dcd056cde3e7a2ec" );



		/*
		// -- Build consignee
		ConsigneeBuilder builder = service.consigneeBuilder();

		Consignee myConsignee = builder
			.setID(261686)
			.setCompanyName( "Et annet navn" )
			.setPostZip( "1337" )
			.setStreetZip( "1337" )
			.setCountry( "NO" )
			.build();

		// -- Save consignee
		Consignee newConsignee = myConsignee.save();
		System.out.println( newConsignee.getID() );

		// -- Remove consignee
		myConsignee.remove();
		*/








		/*
		Consignee consignee = service.getConsignee( 102533 );
		System.out.println( consignee.getCompanyName() );
		*/




		/*
		List<Consignee> consigneeList = service.findConsignee( "test" );
		for( Consignee c : consigneeList ) {
			System.out.println( c.getCompanyName() );
		}
		*/




		/*
		Consignor consignor = service.getDefaultConsignor();
		System.out.println( consignor.getCompanyName() );
		*/




		/*
		Consignment consignment = service.getConsignment( 95256 );
		System.out.println( "SHIPMENT NUMBER: " + consignment.getShipmentNumber() );

		for( Item item : consignment.getItems().getEntries() ) {
			System.out.println( "ITEM NUMBER: " + item.getConnoteNumber() );
		}
		*/






		/*
		List<Consignment> consignmentList = service.findConsignment( "*" );
		
		for( Consignment c : consignmentList ) {
			System.out.println(c.getShipmentNumber());
		}
		*/






		/*
		Consignment consignment = service.getConsignment( 95256 );
		InputStream in = consignment.pdf();
		FileUtilities.saveInputStreamAsFile( in, "test.pdf" );
		*/





		/*
		Consignment consignment = service.getConsignment( 95256 );
		consignment.pdf( "test2.pdf" );
		*/

		




		/*
		Consignment consignment = service.getConsignment( 95256 );
		consignment.print( "PDF" );
		*/





		





	}
}
