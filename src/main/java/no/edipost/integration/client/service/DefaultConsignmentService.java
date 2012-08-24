package no.edipost.integration.client.service;


import com.sun.jersey.api.client.*;
import no.edipost.integration.client.domain.Consignment;
import no.edipost.integration.client.utilities.ErrorUtilities;


/**
 *
 *
 * @author Mathias Bjerke
 */
public class DefaultConsignmentService implements ConsignmentService {
	private WebResource resource;
	private String apiKey;


	public DefaultConsignmentService( Client client, String baseURL, String apiKey ) {
		this.apiKey = apiKey;

		resource = client.resource( baseURL + "/consignment" );
	}


	public Consignment getConsignment( long consignmentID ) {
		Consignment response = null;

		try {
			response = resource
					.path( String.valueOf( consignmentID ) )
					.accept( "application/vnd.edipost.consignment+xml" )
					.header( "Authorization", "Basic " + apiKey )
					.get( new GenericType<Consignment>() {
					} );

		} catch( UniformInterfaceException e ) {
			ErrorUtilities.handleError( e );
		}

		return response;
	}
}
