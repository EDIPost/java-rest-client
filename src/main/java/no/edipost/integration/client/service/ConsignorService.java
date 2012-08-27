package no.edipost.integration.client.service;


import no.edipost.integration.client.domain.Consignor;


/**
 * ProductService contain operations related to {@link Consignor}
 *
 * @author Mathias Bjerke
 */
public interface ConsignorService {
	Consignor getDefaultConsignor();
}
