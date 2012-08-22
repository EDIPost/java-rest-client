package no.edipost.integration.client.utilities;


import com.sun.jersey.api.client.UniformInterfaceException;
import javax.ws.rs.core.Response;
import javax.xml.ws.WebServiceException;


/**
 * @author Mathias Bjerke
 */
public class ErrorUtilities {
	public static void handleError( UniformInterfaceException e ) {
		throw new WebServiceException( Response.Status.fromStatusCode( e.getResponse().getStatus() ).getReasonPhrase() +
					": " + e.getResponse().getEntity( String.class ) );
	}
}
