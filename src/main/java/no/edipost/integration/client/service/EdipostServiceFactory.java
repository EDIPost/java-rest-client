package no.edipost.integration.client.service;


/**
 *
 *
 * @author Mathias Bjerke
 */
public class EdipostServiceFactory {
	public static EdipostService getService( String baseURL, String apiKey  ) {
		return new DefaultEdipostService( baseURL, apiKey );
	}
}
