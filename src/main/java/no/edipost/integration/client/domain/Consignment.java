package no.edipost.integration.client.domain;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 *
 * @author Mathias Bjerke
 */
@XmlRootElement
public class Consignment {
	private Long id;
	private Consignor consignor;
	private Consignee consignee;
	private Product product;
	private ItemCollection items;
	private String shipmentNumber;
	private String contentReference;
	private List<Link> links;


	public Consignment() {
		links = new ArrayList<Link>();
	}


	@XmlAttribute
	public Long getId() {
		return id;
	}


	public void setId( Long id ) {
		this.id = id;
	}


	@XmlElement(name = "consignor")
	public Consignor getConsignor() {
		return consignor;
	}


	public void setConsignor( Consignor consignor ) {
		this.consignor = consignor;
	}


	@XmlElement(name = "consignee")
	public Consignee getConsignee() {
		return consignee;
	}


	public void setConsignee( Consignee consignee ) {
		this.consignee = consignee;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct( Product product ) {
		this.product = product;
	}


	@XmlElement(name = "items")
	public ItemCollection getItems() {
		return items;
	}


	public void setItems( ItemCollection items ) {
		this.items = items;
	}


	public String getShipmentNumber() {
		return shipmentNumber;
	}


	public void setShipmentNumber( String shipmentNumber ) {
		this.shipmentNumber = shipmentNumber;
	}


	public String getContentReference() {
		return contentReference;
	}


	public void setContentReference( String contentReference ) {
		this.contentReference = contentReference;
	}


	public void addLink( Link link ) {
		links.add( link );
	}


	@XmlElement(name = "link")
	public List<Link> getLinks() {
		return links;
	}
}
