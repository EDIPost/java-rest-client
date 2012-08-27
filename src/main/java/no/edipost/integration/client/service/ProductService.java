package no.edipost.integration.client.service;


import no.edipost.integration.client.domain.Product;
import no.edipost.integration.client.domain.consignment.Consignment;
import java.util.List;


/**
 * ProductService contain operations related to {@link Product}
 *
 * @author Mathias Bjerke
 */
public interface ProductService {
	List<Product> products( Consignment consignment );
}
