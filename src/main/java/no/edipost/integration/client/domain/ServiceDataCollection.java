package no.edipost.integration.client.domain;


import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 *
 * @author Mathias Bjerke
 */
public class ServiceDataCollection {
	private List<ServiceData> entries;


	public ServiceDataCollection() {
		entries = new ArrayList<ServiceData>();
	}


	public ServiceDataCollection( List<ServiceData> entries ) {
		this.entries = entries;
	}


	@XmlElement(name = "property")
	public List<ServiceData> getEntries() {
		return entries;
	}


	public void setEntries( List<ServiceData> entries ) {
		this.entries = entries;
	}


	public void addEntry( ServiceData serviceData ) {
		entries.add( serviceData );
	}
}
