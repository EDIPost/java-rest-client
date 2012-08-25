package no.edipost.integration.client.service;


import com.sun.jersey.api.client.*;
import no.edipost.integration.client.domain.consignment.Consignment;
import no.edipost.integration.client.domain.RestCollection;
import no.edipost.integration.client.utilities.ErrorUtilities;
import no.edipost.integration.client.utilities.PrintUtilities;
import javax.ws.rs.core.Response;
import javax.xml.ws.WebServiceException;
import java.io.InputStream;
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


	public InputStream getConsignmentAsPdf( long consignmentID ) {
		InputStream response = null;

		try {
			response = resource
					.path( String.valueOf( consignmentID ) )
					.path( "print" )
					.accept( "application/pdf" )
					.header( "Authorization", "Basic " + apiKey )
					.get( InputStream.class );

		} catch( UniformInterfaceException e ) {
			ErrorUtilities.handleError( e );
		}

		return response;
	}


	public void printConsignment( Long consignmentID, String printerName ) {
		PrintUtilities.printPdf( getConsignmentAsPdf( consignmentID ), printerName );
	}


	public Consignment saveConsignment( Consignment consignment ) {
		ClientResponse response;

		response = resource
				.accept( "application/vnd.edipost.consignment+xml" )
				.type( "application/vnd.edipost.consignment+xml" )
				.header( "Authorization", "Basic " + apiKey )
				.post( ClientResponse.class, consignment );

		if( response.getStatus() != Response.Status.OK.getStatusCode() ) {
			throw new WebServiceException( Response.Status.fromStatusCode( response.getStatus() ).getReasonPhrase() +
					": " + response.getEntity( String.class ) );
		}

		return response.getEntity( Consignment.class );
	}
}
