package no.edipost.integration.client;


import com.sun.jersey.api.client.Client;
import no.edipost.integration.client.domain.Consignee;
import no.edipost.integration.client.service.ConsigneeService;
import sun.misc.BASE64Encoder;


/**
 *
 *
 * @author Mathias Bjerke
 */
public class EdipostService {
	private String baseURL;
	private String apiKey;
	private ConsigneeService consigneeService;


	public EdipostService( String baseURL, String apiKey ) {
		this.baseURL = baseURL;
		this.apiKey = apiKey;

		consigneeService = new ConsigneeService( createClient(), baseURL, packageApiKey( apiKey ) );
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
		return consigneeService.getConsignee( consigneeID );
	}
}
