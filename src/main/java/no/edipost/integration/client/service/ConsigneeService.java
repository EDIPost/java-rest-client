package no.edipost.integration.client.service;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import no.edipost.integration.client.domain.Consignee;
import javax.xml.bind.JAXBElement;


/**
 *
 *
 * @author Mathias Bjerke
 */
public class ConsigneeService {
	private WebResource resource;
	private String apiKey;


	public ConsigneeService( Client client, String baseURL, String apiKey ) {
		this.apiKey = apiKey;

		resource = client.resource( baseURL + "/consignee" );
	}


	public Consignee getConsignee( long consigneeID ) {
		GenericType<JAXBElement<Consignee>> genericType;
		JAXBElement<Consignee> response;

		genericType = new GenericType<JAXBElement<Consignee>>() {};

		response = resource
				.path( String.valueOf( consigneeID ) )
				.accept( "application/vnd.edipost.party+xml" )
				.header( "Authorization", "Basic " + apiKey )
				.get( genericType );

		return response.getValue();
	}
}
