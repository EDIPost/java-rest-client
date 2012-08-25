package no.edipost.integration.client.domain.service;


/**
 *
 *
 * @author Mathias Bjerke
 */
public class BringDomesticCodService extends Service {
	public BringDomesticCodService( double amount, String reference ) {
		setId( 55L );
		addData( new ServiceData( "COD_AMOUNT", String.valueOf( amount ) ) );
		addData( new ServiceData( "COD_REFERENCE", reference ) );
	}
}
