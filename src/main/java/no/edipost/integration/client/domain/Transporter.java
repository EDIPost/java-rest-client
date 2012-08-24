package no.edipost.integration.client.domain;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 *
 * @author Mathias Bjerke
 */
@XmlRootElement
public class Transporter {
	private String name;


	@XmlAttribute
	public String getName() {
		return name;
	}


	public void setName( String name ) {
		this.name = name;
	}
}
