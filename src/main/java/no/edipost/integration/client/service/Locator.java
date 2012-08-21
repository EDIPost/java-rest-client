package no.edipost.integration.client.service;


import java.util.HashMap;
import java.util.Map;


/**
 *
 * 
 * @author Mathias Bjerke
 */
public class Locator {
	private static Map<Class,Object> services = new HashMap<Class, Object>();


	public static <T> void register( Class<T> type, Object service ) {
		services.put( type, service );
	}


	public static <T> T resolve( Class<T> type ) {
		Object service = services.get( type );

		if( service == null ) {
			throw new RuntimeException( "Service not found" );
		}

		return type.cast( service );
	}
}
