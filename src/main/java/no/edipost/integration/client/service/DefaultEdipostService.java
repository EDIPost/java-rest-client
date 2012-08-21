package no.edipost.integration.client.service;


import com.sun.jersey.api.client.Client;
import no.edipost.integration.client.builder.ConsigneeBuilder;
import no.edipost.integration.client.builder.ConsignmentBuilder;
import no.edipost.integration.client.builder.ConsignorBuilder;
import no.edipost.integration.client.domain.Consignee;
import sun.misc.BASE64Encoder;


/**
 *
 *
 * @author Mathias Bjerke
 */
public class DefaultEdipostService implements EdipostService {
	private String baseURL;
	private String apiKey;


	public DefaultEdipostService( String baseURL, String apiKey ) {
		this.baseURL = baseURL;
		this.apiKey = apiKey;

		Locator.register( ConsigneeService.class, new DefaultConsigneeService( createClient(), baseURL, packageApiKey( apiKey ) ) );
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


	public ConsignorBuilder consignorBuilder() {
		return new ConsignorBuilder();
	}


	public ConsigneeBuilder consigneeBuilder() {
		return new ConsigneeBuilder();
	}


	public ConsignmentBuilder consignmentBuilder() {
		return new ConsignmentBuilder();
	}


	public Consignee getConsignee( long consigneeID ) {
		return Locator.resolve( ConsigneeService.class ).getConsignee( consigneeID );
	}
}
