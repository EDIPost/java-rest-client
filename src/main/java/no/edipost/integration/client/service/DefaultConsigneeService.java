package no.edipost.integration.client.service;


import com.sun.jersey.api.client.*;
import no.edipost.integration.client.domain.Consignee;
import no.edipost.integration.client.domain.RestCollection;
import no.edipost.integration.client.utilities.ErrorUtilities;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;
import javax.xml.ws.WebServiceException;
import java.util.List;


/**
 * Default implementation of {@link ConsigneeService}.
 *
 * @author Mathias Bjerke
 */
public class DefaultConsigneeService implements ConsigneeService {
	private WebResource resource;
	private String apiKey;


	public DefaultConsigneeService( Client client, String baseURL, String apiKey ) {
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


	public Consignee saveConsignee( Consignee consignee ) {
		ClientResponse response;

		// If there is an ID, we should try to update the consignee
		if( consignee.getID() != null && consignee.getID() > 0 ) {
			response = resource
					.path( String.valueOf( consignee.getID() ) )
					.accept( "application/vnd.edipost.party+xml" )
					.type( "application/vnd.edipost.party+xml" )
					.header( "Authorization", "Basic " + apiKey )
					.put( ClientResponse.class, consignee );

		// if not, we should create a new one
		} else {
			response = resource
					.accept( "application/vnd.edipost.party+xml" )
					.type( "application/vnd.edipost.party+xml" )
					.header( "Authorization", "Basic " + apiKey )
					.post( ClientResponse.class, consignee );
		}

		if( response.getStatus() != Response.Status.OK.getStatusCode() ) {
			throw new WebServiceException( Response.Status.fromStatusCode( response.getStatus() ).getReasonPhrase() +
					": " + response.getEntity( String.class ) );
		}

		return response.getEntity( Consignee.class );
	}


	public boolean removeConsignee( Long consigneeID ) {
		ClientResponse response;

		response = resource
				.path( String.valueOf( consigneeID ) )
				.accept( "application/vnd.edipost.party+xml" )
				.type( "application/vnd.edipost.party+xml" )
				.header( "Authorization", "Basic " + apiKey )
				.delete( ClientResponse.class );

		if( response.getStatus() != Response.Status.NO_CONTENT.getStatusCode() ) {
			throw new WebServiceException( Response.Status.fromStatusCode( response.getStatus() ).getReasonPhrase() +
					": " + response.getEntity( String.class ) );
		}

		return true;
	}


	public List<Consignee> findConsignee( String searchPhrase ) {
		RestCollection<Consignee> response = null;

		try {
			response = resource
					.queryParam( "query", searchPhrase )
					.accept( "application/vnd.edipost.collection+xml" )
					.header( "Authorization", "Basic " + apiKey )
					.get( new GenericType<RestCollection<Consignee>>() {
					} );

		} catch( UniformInterfaceException e ) {
			ErrorUtilities.handleError( e );
		}

		return response.getEntries();
	}
}
