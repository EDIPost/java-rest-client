package no.edipost.integration.client.service;


import com.sun.jersey.api.client.Client;
import no.edipost.integration.client.builder.ConsigneeBuilder;
import no.edipost.integration.client.builder.ConsignmentBuilder;
import no.edipost.integration.client.domain.Consignee;
import no.edipost.integration.client.domain.consignment.Consignment;
import no.edipost.integration.client.domain.Consignor;
import sun.misc.BASE64Encoder;
import java.util.List;


/**
 *
 *
 * @author Mathias Bjerke
 */
class DefaultEdipostService implements EdipostService {
	private String baseURL;
	private String apiKey;


	public DefaultEdipostService( String baseURL, String apiKey ) {
		this.baseURL = baseURL;
		this.apiKey = apiKey;

		Locator.register( ConsigneeService.class, new DefaultConsigneeService( createClient(), baseURL, packageApiKey( apiKey ) ) );
		Locator.register( ConsignorService.class, new DefaultConsignorService( createClient(), baseURL, packageApiKey( apiKey ) ) );
		Locator.register( ConsignmentService.class, new DefaultConsignmentService( createClient(), baseURL, packageApiKey( apiKey ) ) );
	}


	private Client createClient() {
		Client client;

		client = Client.create();
		client.setFollowRedirects( true );

		return client;
	}


	private String packageApiKey( String apiKey ) {
		return new BASE64Encoder().encode( ("api:" + apiKey).getBytes() );
	}


	/*
	 * Consignors
	 */

	public Consignor getDefaultConsignor() {
		return Locator.resolve( ConsignorService.class ).getDefaultConsignor();
	}


	/*
	 * Consignees
	 */

	public ConsigneeBuilder consigneeBuilder() {
		return new ConsigneeBuilder();
	}


	public Consignee getConsignee( long consigneeID ) {
		return Locator.resolve( ConsigneeService.class ).getConsignee( consigneeID );
	}


	public List<Consignee> findConsignee( String searchPhrase ) {
		return Locator.resolve( ConsigneeService.class ).findConsignee( searchPhrase );
	}


	/*
	 * Consignments
	 */

	public ConsignmentBuilder consignmentBuilder() {
		return new ConsignmentBuilder();
	}


	public Consignment getConsignment( long consignmentID ) {
		return Locator.resolve( ConsignmentService.class ).getConsignment( consignmentID );
	}


	public List<Consignment> findConsignment( String searchPhrase ) {
		return Locator.resolve( ConsignmentService.class ).findConsignment( searchPhrase );
	}
}
