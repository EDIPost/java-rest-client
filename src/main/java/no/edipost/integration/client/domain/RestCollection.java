package no.edipost.integration.client.domain;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;


/**
 *
 *
 * @author Mathias Bjerke
 */
@XmlRootElement(name = "collection")
@XmlSeeAlso({Consignee.class, Consignment.class})
public class RestCollection<T> {
	private List<T> entries;


	@XmlElement(name = "entry")
	public List<T> getEntries() {
		return entries;
	}


	public void setEntries( List<T> entries ) {
		this.entries = entries;
	}
}
