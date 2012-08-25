package no.edipost.integration.client.builder;


import no.edipost.integration.client.domain.*;
import no.edipost.integration.client.domain.consignment.Consignment;
import no.edipost.integration.client.domain.consignment.Item;
import no.edipost.integration.client.domain.consignment.ItemCollection;
import no.edipost.integration.client.domain.service.Service;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Mathias Bjerke
 */
public class ConsignmentBuilder {
	private long id;
	private long consignorID;
	private long consigneeID;
	private int productID;
	private List<Item> items;
	private List<Service> services;
	private String contentReference;


	public ConsignmentBuilder() {
		items = new ArrayList<Item>();
		services = new ArrayList<Service>();
	}


	public ConsignmentBuilder setId( Long id ) {
		this.id = id;
		return this;
	}


	public ConsignmentBuilder setConsignorID( long consignorID ) {
		this.consignorID = consignorID;
		return this;
	}


	public ConsignmentBuilder setConsigneeID( long consigneeID ) {
		this.consigneeID = consigneeID;
		return this;
	}


	public ConsignmentBuilder setProductID( int productID ) {
		this.productID = productID;
		return this;
	}


	public ConsignmentBuilder addItem( Item item ) {
		items.add( item );
		return this;
	}


	public ConsignmentBuilder addService( Service service ) {
		services.add( service );
		return this;
	}


	public ConsignmentBuilder setContentReference( String contentReference ) {
		this.contentReference = contentReference;
		return this;
	}


	public Consignment build() {
		Consignor consignor = new Consignor();
		consignor.setID( consignorID );

		Consignee consignee = new Consignee();
		consignee.setID( consigneeID );

		ItemCollection itemCollection = new ItemCollection();
		itemCollection.setEntries( items );

		Product product = new Product();
		product.setId( productID );
		product.setServices( services );

		Consignment consignment = new Consignment();
		consignment.setId( id );
		consignment.setConsignor( consignor );
		consignment.setConsignee( consignee );
		consignment.setItems( itemCollection );
		consignment.setProduct( product );
		consignment.setContentReference( contentReference );

		return consignment;
	}
}
