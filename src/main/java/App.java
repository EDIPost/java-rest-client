import no.edipost.integration.client.builder.ConsignmentBuilder;
import no.edipost.integration.client.domain.Consignor;
import no.edipost.integration.client.domain.Product;
import no.edipost.integration.client.domain.consignment.Consignment;
import no.edipost.integration.client.domain.consignment.Item;
import no.edipost.integration.client.domain.service.BringDomesticCodService;
import no.edipost.integration.client.service.EdipostService;
import no.edipost.integration.client.service.EdipostServiceFactory;
import java.util.List;


/**
 * Hello world!
 */
public class App {
	public static void main( String[] args ) {
		
		// -- Connect to service
		//EdipostService service = new DefaultEdipostService( "http://localhost:2847/edipost-integration", "f666b087a3bf58ef24082882dcd056cde3e7a2ec" );
		EdipostService service = EdipostServiceFactory.getService( "https://api.dev.edipost.no", "07add61e089e3e8d3a1a7e34e71f462eee2ef8f5" );



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





		Consignor consignor = service.getDefaultConsignor();
		System.out.println( consignor.getCompanyName() );





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

		





		Consignment consignment = service.getConsignment( 5190611 );
		consignment.print( "PDF" );








		/*
		ConsignmentBuilder builder = service.consignmentBuilder();

		Consignment myConsignment = builder
			.setConsignorID( 3311 )
			.setConsigneeID( 191511 )
			.addItem( new Item( 1.0, 10.0, 10.0, 10.0 ) )
			.setProductID( 13 )
			.addService( new BringDomesticCodService( 1200.00, "123456789" ) )
			.setContentReference( "Innholdet" )
			.build();
		 */

		//myConsignment.save();





		/*
		Consignment postageConsignment = myConsignment.postage();

		for( Item item : postageConsignment.getItems().getEntries() ) {
			System.out.println( item.getCost() + " - " + item.getVat() );
		}
		*/


		/*
		List<Product> products = myConsignment.products();
		System.out.println( products.size() );
		 */



	}
}
