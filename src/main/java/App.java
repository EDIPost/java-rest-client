import no.edipost.integration.client.builder.ConsigneeBuilder;
import no.edipost.integration.client.domain.Consignee;
import no.edipost.integration.client.service.DefaultEdipostService;
import no.edipost.integration.client.service.EdipostService;
import javax.print.PrintService;
import java.awt.print.PrinterJob;


/**
 * Hello world!
 */
public class App {
	public static void main( String[] args ) {

		
		// -- Connect to service
		EdipostService service = new DefaultEdipostService( "http://localhost:2847/edipost-integration", "f666b087a3bf58ef24082882dcd056cde3e7a2ec" );



		// -- Build consignee
		ConsigneeBuilder builder = service.consigneeBuilder();

		Consignee myConsignee = builder
			.setID(261685)
			.setCompanyName( "Et annet navn" )
			.setPostZip( "1337" )
			.setStreetZip( "1337" )
			.setCountry( "NO" )
			.build();

		// -- Save consignee
		Consignee newConsignee = myConsignee.save();
		System.out.println( newConsignee.getID() );

		// -- Remove consignee
		//myConsignee.remove();









		/*
		Consignee consignee = service.getConsignee( 102533 );

		System.out.println( consignee.getCompanyName() );
		*/













		/*
		PDDocument document;
		String printerName = "PDF";

		try {
			document = PDDocument.load( "consignment.pdf" );

			PrinterJob printJob = PrinterJob.getPrinterJob();
			printJob.setJobName( "Edipost label" );
			printJob.setPrintService( getPrintServiceByName( printerName ) );

			document.silentPrint( printJob );

			document.close();
			

		} catch( Exception e ) {
			e.printStackTrace();
		}
		*/




	}


	private static PrintService getPrintServiceByName( String printerName ) {
		PrintService[] printServices = PrinterJob.lookupPrintServices();

		for( PrintService printService : printServices ) {
			if( printService.getName().equals( printerName ) ) {
				return printService;
			}
		}

		return null;
	}
}
