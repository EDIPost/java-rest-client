package no.edipost.integration.client.service;


import no.edipost.integration.client.domain.consignment.Consignment;
import java.io.InputStream;
import java.util.List;


/**
 * ProductService contain operations related to {@link Consignment}
 *
 * @author Mathias Bjerke
 */
public interface ConsignmentService {
	Consignment getConsignment( long consignmentID );
	List<Consignment> findConsignment( String searchPhrase );
	InputStream getConsignmentAsPdf( long consignmentID );
	void printConsignment( Long id, String printerName );
	Consignment saveConsignment( Consignment consignment );
	Consignment postage( Consignment consignment );
}
