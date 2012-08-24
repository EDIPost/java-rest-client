package no.edipost.integration.client.service;


import no.edipost.integration.client.domain.Consignment;
import java.util.List;


/**
 *
 *
 * @author Mathias Bjerke
 */
public interface ConsignmentService {
	Consignment getConsignment( long consignmentID );
	List<Consignment> findConsignment( String searchPhrase );
}
