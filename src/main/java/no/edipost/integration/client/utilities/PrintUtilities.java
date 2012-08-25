package no.edipost.integration.client.utilities;


import no.edipost.integration.client.exception.PrintException;
import org.apache.pdfbox.pdmodel.PDDocument;
import javax.print.PrintService;
import java.awt.print.PrinterJob;
import java.io.InputStream;


/**
 *
 *
 * @author Mathias Bjerke
 */
public class PrintUtilities {
	public static void printPdf( InputStream in, String printerName ) {
		PDDocument document;
		PrinterJob printJob;

		try {
			document = PDDocument.load( in );

			printJob = PrinterJob.getPrinterJob();
			printJob.setJobName( "Edipost label" );
			printJob.setPrintService( getPrintServiceByName( printerName ) );

			document.silentPrint( printJob );
			document.close();

		} catch( Exception e ) {
			throw new PrintException( "Could not print label", e );
		}
	}


	public static PrintService getPrintServiceByName( String printerName ) {
		PrintService[] printServices = PrinterJob.lookupPrintServices();

		for( PrintService printService : printServices ) {
			if( printService.getName().equals( printerName ) ) {
				return printService;
			}
		}

		throw new PrintException( "There is no printer named " + printerName );
	}
}
