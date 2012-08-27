package no.edipost.integration.client.domain;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * A transporter represents the carrier in a consignment. The carrier is typically a company transporting the
 * {@link no.edipost.integration.client.domain.consignment.Consignment} from the {@link Consignor} to the {@link Consignee}
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
