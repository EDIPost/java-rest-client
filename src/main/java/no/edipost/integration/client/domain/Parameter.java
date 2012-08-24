package no.edipost.integration.client.domain;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 *
 * @author Mathias Bjerke
 */
@XmlRootElement
@XmlAccessorType( XmlAccessType.NONE)
public class Parameter {
	private String name;
	private String pattern;


	@XmlAttribute
	public String getName() {
		return name;
	}


	public void setName( String name ) {
		this.name = name;
	}


	public String getPattern() {
		return pattern;
	}


	public void setPattern( String pattern ) {
		this.pattern = pattern;
	}
}
