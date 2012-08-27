package no.edipost.integration.client.domain.consignment;


import no.edipost.integration.client.domain.Consignee;
import no.edipost.integration.client.domain.Consignor;
import no.edipost.integration.client.domain.Product;
import no.edipost.integration.client.service.ConsignmentService;
import no.edipost.integration.client.service.Locator;
import no.edipost.integration.client.service.ProductService;
import no.edipost.integration.client.utilities.FileUtilities;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.InputStream;
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


	public InputStream pdf() {
		return Locator.resolve( ConsignmentService.class ).getConsignmentAsPdf( getId() );
	}


	public void pdf( String filename ) {
		InputStream in = Locator.resolve( ConsignmentService.class ).getConsignmentAsPdf( getId() );
		FileUtilities.saveInputStreamAsFile( in, filename);
	}


	public void print( String printerName ) {
		Locator.resolve( ConsignmentService.class ).printConsignment( getId(), printerName );
	}


	public Consignment save() {
		return Locator.resolve( ConsignmentService.class ).saveConsignment( this );
	}


	public Consignment postage() {
		return Locator.resolve( ConsignmentService.class ).postage( this );
	}


	public List<Product> products() {
		return Locator.resolve( ProductService.class ).products( this );
	}
}
