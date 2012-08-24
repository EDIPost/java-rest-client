package no.edipost.integration.client.domain;


import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 *
 * @author Mathias Bjerke
 */
@XmlRootElement
public class Contact {
	private String name;
	private String telephone;
	private String cellphone;
	private String telefax;
	private String email;


	public String getName() {
		return name;
	}


	public void setName( String name ) {
		this.name = name;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone( String telephone ) {
		this.telephone = telephone;
	}


	public String getCellphone() {
		return cellphone;
	}


	public void setCellphone( String cellphone ) {
		this.cellphone = cellphone;
	}


	public String getTelefax() {
		return telefax;
	}


	public void setTelefax( String telefax ) {
		this.telefax = telefax;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail( String email ) {
		this.email = email;
	}
}
