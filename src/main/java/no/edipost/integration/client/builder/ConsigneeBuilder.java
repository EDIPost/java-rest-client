package no.edipost.integration.client.builder;


import no.edipost.integration.client.domain.Address;
import no.edipost.integration.client.domain.Consignee;
import no.edipost.integration.client.domain.Contact;


/**
 * Builder class to create consignees
 *
 * @author Mathias Bjerke
 */
public class ConsigneeBuilder {
	private long   id;
	private String companyName;
	private String customerNumber;
	private String streetAddress;
	private String streetZip;
	private String streetCity;
	private String postAddress;
	private String postZip;
	private String postCity;
	private String country;
	private String contactName;
	private String contactPhone;
	private String contactCellPhone;
	private String contactEmail;



	public ConsigneeBuilder() {
	}


	public ConsigneeBuilder setID( long id ) {
		this.id = id;
		return this;
	}


	public ConsigneeBuilder setCompanyName( String companyName ) {
		this.companyName = companyName;
		return this;
	}


	public ConsigneeBuilder setCustomerNumber( String customerNumber ) {
		this.customerNumber = customerNumber;
		return this;
	}


	public ConsigneeBuilder setStreetAddress( String streetAddress ) {
		this.streetAddress = streetAddress;
		return this;
	}


	public ConsigneeBuilder setStreetZip( String streetZip ) {
		this.streetZip = streetZip;
		return this;
	}


	public ConsigneeBuilder setStreetCity( String streetCity ) {
		this.streetCity = streetCity;
		return this;
	}


	public ConsigneeBuilder setPostAddress( String postAddress ) {
		this.postAddress = postAddress;
		return this;
	}


	public ConsigneeBuilder setPostZip( String postZip ) {
		this.postZip = postZip;
		return this;
	}


	public ConsigneeBuilder setPostCity( String postCity ) {
		this.postCity = postCity;
		return this;
	}


	public ConsigneeBuilder setCountry( String country ) {
		this.country = country;
		return this;
	}


	public ConsigneeBuilder setContactName( String contactName ) {
		this.contactName = contactName;
		return this;
	}


	public ConsigneeBuilder setContactPhone( String contactPhone ) {
		this.contactPhone = contactPhone;
		return this;
	}


	public ConsigneeBuilder setContactCellPhone( String contactCellPhone ) {
		this.contactCellPhone = contactCellPhone;
		return this;
	}


	public ConsigneeBuilder setContactEmail( String contactEmail ) {
		this.contactEmail = contactEmail;
		return this;
	}


	public Consignee build() {
		Address po = new Address();
		po.setAddress( postAddress );
		po.setZipCode( postZip );
		po.setCity( postCity );

		Address sa = new Address();
		sa.setAddress( streetAddress );
		sa.setZipCode( streetZip );
		sa.setCity( streetCity );

		Contact contact = new Contact();
		contact.setName( contactName );
		contact.setTelephone( contactPhone );
		contact.setCellphone( contactCellPhone );
		contact.setEmail( contactEmail );

		Consignee consignee = new Consignee();
		consignee.setID( id );
		consignee.setCompanyName( companyName );
		consignee.setCustomerNumber( customerNumber );
		consignee.setPostAddress( po );
		consignee.setStreetAddress( sa );
		consignee.setCountry( country );
		consignee.setContact( contact );

		return consignee;
	}
}
