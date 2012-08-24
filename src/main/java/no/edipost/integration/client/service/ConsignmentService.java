package no.edipost.integration.client.service;


import no.edipost.integration.client.domain.Consignment;


/**
 *
 * 
 * @author Mathias Bjerke
 */
public interface ConsignmentService {
	Consignment getConsignment( long consignmentID );
}
