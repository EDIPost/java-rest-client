package no.edipost.integration.client.domain;


import javax.xml.bind.annotation.XmlElement;
import java.util.List;


/**
 *
 *
 * @author Mathias Bjerke
 */
public class ItemCollection {
	private List<Item> entries;


	public ItemCollection() {

	}


	public ItemCollection( List<Item> entries ) {
		this.entries = entries;
	}


	@XmlElement(name = "item")
	public List<Item> getEntries() {
		return entries;
	}


	public void setEntries( List<Item> entries ) {
		this.entries = entries;
	}
}
