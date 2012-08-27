package no.edipost.integration.client.service;


import com.sun.jersey.api.client.*;
import no.edipost.integration.client.domain.Consignor;
import no.edipost.integration.client.utilities.ErrorUtilities;


/**
 * Default implementation of {@link ConsignorService}.
 *
 * @author Mathias Bjerke
 */
public class DefaultConsignorService implements ConsignorService {
	private WebResource resource;
	private String apiKey;


	public DefaultConsignorService( Client client, String baseURL, String apiKey ) {
		this.apiKey = apiKey;

		resource = client.resource( baseURL + "/consignor" );
	}


	public Consignor getDefaultConsignor() {
		Consignor response = null;

		try {
			response = resource
					.path( "default" )
					.accept( "application/vnd.edipost.party+xml" )
					.header( "Authorization", "Basic " + apiKey )
					.get( new GenericType<Consignor>() {
					} );

		} catch( UniformInterfaceException e ) {
			ErrorUtilities.handleError( e );
		}

		return response;
	}
}
