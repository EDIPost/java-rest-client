package no.edipost.integration.client.service;


import no.edipost.integration.client.builder.ConsigneeBuilder;
import no.edipost.integration.client.builder.ConsignmentBuilder;
import no.edipost.integration.client.domain.Consignee;
import no.edipost.integration.client.domain.consignment.Consignment;
import no.edipost.integration.client.domain.Consignor;
import java.util.List;


/**
 * EdipostService is the main entry point for all communication with the server.
 *
 * An instance of EdipostService can be obtained using EdipostServiceFactory.
 *
 * EdipostService service = EdipostServiceFactory.getService( "http://api.edipost.no", "myapikey" );
 *
 * @author Mathias Bjerke
 */
public interface EdipostService {
	/**
	 * Returns the default consignor for the customer. Most customers have only one consignor.
	 *
	 * @return the default consignor
	 */
	Consignor getDefaultConsignor();


	/**
	 * Creates a builder object used to build consignees
	 *
	 * @return a builder object
	 */
	ConsigneeBuilder consigneeBuilder();


	/**
	 * Get a consignee by it's ID.
	 *
	 * The ID can be found by searching for consignees by findConsignee, or when you create a new consignee
	 *
	 * @param consigneeID the ID of the consignee
	 * @return a consignee
	 */
	Consignee getConsignee( long consigneeID );


	/**
	 * Search for consignees
	 *
	 * @param searchPhrase A phrase used when searching for consignees
	 * @return a list of consignees
	 */
	List<Consignee> findConsignee( String searchPhrase );


	/**
	 * Creates a builder object used to build consignments
	 * 
	 * @return a builder object
	 */
	ConsignmentBuilder consignmentBuilder();


	/**
	 * Get a consignment by it's ID
	 *
	 * The ID can be found by searching for consignments by findConsignment, or when you create a new consignment
	 *
	 * @param consignmentID the ID of the consignment
	 * @return a consignment
	 */
	Consignment getConsignment( long consignmentID );

	
	/**
	 * Search for consignments
	 *
	 * @param searchPhrase A phrase used when searching for consignments
	 * @return a list of consignments
	 */
	List<Consignment> findConsignment( String searchPhrase );
}
