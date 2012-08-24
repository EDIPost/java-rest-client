package no.edipost.integration.client.domain;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 *
 * @author Mathias Bjerke
 */
@XmlRootElement
public class ServiceData {
	private String key;
	private String value;


	@XmlAttribute
	public String getKey() {
		return key;
	}


	public void setKey( String key ) {
		this.key = key;
	}


	@XmlAttribute
	public String getValue() {
		return value;
	}


	public void setValue( String value ) {
		this.value = value;
	}
}
