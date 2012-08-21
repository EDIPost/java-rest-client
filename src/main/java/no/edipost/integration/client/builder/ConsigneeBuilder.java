package no.edipost.integration.client.builder;


import no.edipost.integration.client.domain.Consignee;


/**
 *
 *
 * @author Mathias Bjerke
 */
public class ConsigneeBuilder {
	private String companyName;
	private String streetAddress;
	private String streetZip;
	private String streetCity;
	private String country;


	public ConsigneeBuilder() {
	}


	public ConsigneeBuilder setCompanyName( String companyName ) {
		this.companyName = companyName;
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


	public ConsigneeBuilder setCountry( String country ) {
		this.country = country;
		return this;
	}


	public Consignee build() {
		Consignee consignee = new Consignee();

		return consignee;
	}
}
