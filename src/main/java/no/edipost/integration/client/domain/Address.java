package no.edipost.integration.client.domain;


import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 *
 * @author Mathias Bjerke
 */
@XmlRootElement
public class Address {
	private String address;
	private String zipCode;
	private String city;


	public Address() {
	}


	public String getAddress() {
		return address;
	}


	public void setAddress( String address ) {
		this.address = address;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode( String zipCode ) {
		this.zipCode = zipCode;
	}


	public String getCity() {
		return city;
	}


	public void setCity( String city ) {
		this.city = city;
	}
}
