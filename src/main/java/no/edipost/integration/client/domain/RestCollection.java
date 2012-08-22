package no.edipost.integration.client.domain;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.List;


/**
 *
 *
 * @author Mathias Bjerke
 */
@XmlRootElement(name = "collection")
@XmlSeeAlso({Consignee.class})
public class RestCollection<T> {
	private List<T> entries;
	private List<Link> links;


	public RestCollection() {
		entries = new ArrayList<T>();
	}


	public RestCollection( List<T> entries ) {
		this.entries = entries;
	}


	public RestCollection( List<T> entries, List<Link> links ) {
		this.entries = entries;
		this.links = links;
	}


	@XmlElement(name = "entry")
	public List<T> getEntries() {
		return entries;
	}


	public void setEntries( List<T> entries ) {
		this.entries = entries;
	}


	public void addEntry( T entry ) {
		entries.add( entry );
	}


	@XmlElement(name = "link")
	public List<Link> getLinks() {
		return links;
	}


	public void setLinks( List<Link> links ) {
		this.links = links;
	}
}
