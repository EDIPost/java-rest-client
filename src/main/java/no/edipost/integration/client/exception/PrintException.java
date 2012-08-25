package no.edipost.integration.client.exception;


/**
 *
 *
 * @author Mathias Bjerke
 */
public class PrintException extends RuntimeException {
	public PrintException( String s ) {
		super( s );
	}


	public PrintException( String s, Throwable throwable ) {
		super( s, throwable );
	}
}
