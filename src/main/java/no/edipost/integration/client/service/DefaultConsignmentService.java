package no.edipost.integration.client.service;


import com.sun.jersey.api.client.*;
import no.edipost.integration.client.domain.Consignment;
import no.edipost.integration.client.domain.RestCollection;
import no.edipost.integration.client.utilities.ErrorUtilities;
import java.util.List;


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


	public List<Consignment> findConsignment( String searchPhrase ) {
		RestCollection<Consignment> response = null;

		try {
			response = resource
					.queryParam( "query", searchPhrase )
					.accept( "application/vnd.edipost.collection+xml" )
					.header( "Authorization", "Basic " + apiKey )
					.get( new GenericType<RestCollection<Consignment>>() {
					} );

		} catch( UniformInterfaceException e ) {
			ErrorUtilities.handleError( e );
		}

		return response.getEntries();
	}
}
