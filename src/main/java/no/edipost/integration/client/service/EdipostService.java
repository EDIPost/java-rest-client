package no.edipost.integration.client.service;


import no.edipost.integration.client.builder.ConsigneeBuilder;
import no.edipost.integration.client.builder.ConsignmentBuilder;
import no.edipost.integration.client.builder.ConsignorBuilder;
import no.edipost.integration.client.domain.Consignee;


/**
 * @author Mathias Bjerke
 */
public interface EdipostService {
	ConsignorBuilder consignorBuilder();
	ConsigneeBuilder consigneeBuilder();
	ConsignmentBuilder consignmentBuilder();
	Consignee getConsignee( long consigneeID );
}
