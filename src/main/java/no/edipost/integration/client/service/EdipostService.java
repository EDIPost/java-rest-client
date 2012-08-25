package no.edipost.integration.client.service;


import no.edipost.integration.client.builder.ConsigneeBuilder;
import no.edipost.integration.client.builder.ConsignmentBuilder;
import no.edipost.integration.client.domain.Consignee;
import no.edipost.integration.client.domain.consignment.Consignment;
import no.edipost.integration.client.domain.Consignor;
import java.util.List;


/**
 *
 *
 * @author Mathias Bjerke
 */
public interface EdipostService {
	Consignor getDefaultConsignor();

	ConsigneeBuilder consigneeBuilder();
	Consignee getConsignee( long consigneeID );
	List<Consignee> findConsignee( String searchPhrase );

	ConsignmentBuilder consignmentBuilder();
	Consignment getConsignment( long consignmentID );
	List<Consignment> findConsignment( String searchPhrase );
}
