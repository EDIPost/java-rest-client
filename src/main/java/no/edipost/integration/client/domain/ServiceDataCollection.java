package no.edipost.integration.client.domain;


import javax.xml.bind.annotation.XmlElement;
import java.util.List;


/**
 *
 *
 * @author Mathias Bjerke
 */
public class ServiceDataCollection {
	private List<ServiceData> entries;


	@XmlElement(name = "property")
	public List<ServiceData> getEntries() {
		return entries;
	}


	public void setEntries( List<ServiceData> entries ) {
		this.entries = entries;
	}
}
