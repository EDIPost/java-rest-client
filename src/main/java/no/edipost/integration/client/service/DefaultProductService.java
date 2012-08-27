package no.edipost.integration.client.service;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import no.edipost.integration.client.domain.Product;
import no.edipost.integration.client.domain.RestCollection;
import no.edipost.integration.client.domain.consignment.Consignment;
import no.edipost.integration.client.domain.consignment.Item;
import no.edipost.integration.client.utilities.ErrorUtilities;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;


/**
 * Default implementation of {@link ProductService}.
 *
 * @author Mathias Bjerke
 */
public class DefaultProductService implements ProductService {
	private WebResource resource;
	private String apiKey;


	public DefaultProductService( Client client, String baseURL, String apiKey ) {
		this.apiKey = apiKey;

		resource = client.resource( baseURL + "/product" );
	}


	public List<Product> products( Consignment consignment ) {
		RestCollection<Product> response = null;
		MultivaluedMap<String,String> params;

		params = new MultivaluedMapImpl();

		for( Item item : consignment.getItems().getEntries() ) {
			params.add( "weight", String.valueOf( item.getWeight() ) );
		}

		try {
			response = resource
					.path( "filtered" )
					.queryParams( params )
					.path( String.valueOf( consignment.getConsignee().getID() ) )
					.accept( "application/vnd.edipost.collection+xml" )
					.header( "Authorization", "Basic " + apiKey )
					.get( new GenericType<RestCollection<Product>>() {
					} );

		} catch( UniformInterfaceException e ) {
			ErrorUtilities.handleError( e );
		}

		return response.getEntries();
	}
}
