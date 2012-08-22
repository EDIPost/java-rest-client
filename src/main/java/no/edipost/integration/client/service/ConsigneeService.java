package no.edipost.integration.client.service;


import no.edipost.integration.client.domain.Consignee;


/**
 * @author Mathias Bjerke
 */
public interface ConsigneeService {
	Consignee getConsignee( long consigneeID );
	Consignee saveConsignee( Consignee consignee );
}
