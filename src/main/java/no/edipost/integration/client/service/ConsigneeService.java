package no.edipost.integration.client.service;


import no.edipost.integration.client.domain.Consignee;
import java.util.List;


/**
 * ProductService contain operations related to {@link Consignee}
 *
 * @author Mathias Bjerke
 */
public interface ConsigneeService {
	Consignee getConsignee( long consigneeID );
	Consignee saveConsignee( Consignee consignee );
	boolean removeConsignee( Long consigneeID );
	List<Consignee> findConsignee( String searchPhrase );
}
