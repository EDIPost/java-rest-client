package no.edipost.integration.client.domain;


import no.edipost.integration.client.service.ConsigneeService;
import no.edipost.integration.client.service.Locator;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * A Consignee represents the receiving end of a {@link no.edipost.integration.client.domain.consignment.Consignment}
 *
 * @author Mathias Bjerke
 */
@XmlRootElement
public class Consignee {
	private Long ID;
	private String companyName;
	private String customerNumber;
	private String country;
	private Address streetAddress;
	private Address postAddress;
	private Contact contact;


	@XmlAttribute
	public Long getID() {
		return ID;
	}


	public void setID( Long ID ) {
		this.ID = ID;
	}


	public String getCompanyName() {
		return companyName;
	}

	
	public void setCompanyName( String companyName ) {
		this.companyName = companyName;
	}


	public String getCustomerNumber() {
		return customerNumber;
	}


	public void setCustomerNumber( String customerNumber ) {
		this.customerNumber = customerNumber;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry( String country ) {
		this.country = country;
	}


	public Address getStreetAddress() {
		return streetAddress;
	}


	public void setStreetAddress( Address streetAddress ) {
		this.streetAddress = streetAddress;
	}


	public Address getPostAddress() {
		return postAddress;
	}


	public void setPostAddress( Address postAddress ) {
		this.postAddress = postAddress;
	}


	public Contact getContact() {
		return contact;
	}


	public void setContact( Contact contact ) {
		this.contact = contact;
	}


	public Consignee save() {
		return Locator.resolve( ConsigneeService.class ).saveConsignee( this );
	}


	public boolean remove() {
		return Locator.resolve( ConsigneeService.class ).removeConsignee( getID() );
	}
}
