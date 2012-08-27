package no.edipost.integration.client.service;


/**
 * Factory used to obtain an instance of {@link EdipostService}
 *
 * <p><blockquote><pre>
 * {@code
 * EdipostService service = EdipostServiceFactory.getService( "http://api.edipost.no", "myapikey" );
 * }
 * </pre></blockquote></p>
 *
 * @author Mathias Bjerke
 * @see EdipostService
 */
public class EdipostServiceFactory {
	public static EdipostService getService( String baseURL, String apiKey  ) {
		return new DefaultEdipostService( baseURL, apiKey );
	}
}
