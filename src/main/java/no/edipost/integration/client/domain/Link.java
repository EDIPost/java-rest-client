package no.edipost.integration.client.domain;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Class representing a HTTP link
 *
 * @author Mathias Bjerke
 */
@XmlRootElement
public class Link {
	private String href;
	private String rel;
	private String method;
	private String type;
	private String title;


	@XmlAttribute
	public String getHref() {
		return href;
	}


	public void setHref( String href ) {
		this.href = href;
	}

	@XmlAttribute
	public String getRel() {
		return rel;
	}


	public void setRel( String rel ) {
		this.rel = rel;
	}


	@XmlAttribute
	public String getMethod() {
		return method;
	}


	public void setMethod( String method ) {
		this.method = method;
	}


	@XmlAttribute
	public String getType() {
		return type;
	}


	public void setType( String type ) {
		this.type = type;
	}


	@XmlAttribute
	public String getTitle() {
		return title;
	}


	public void setTitle( String title ) {
		this.title = title;
	}
}
