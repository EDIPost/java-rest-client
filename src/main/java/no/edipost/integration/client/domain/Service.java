package no.edipost.integration.client.domain;


import javax.xml.bind.annotation.*;


/**
 *
 *
 * @author Mathias Bjerke
 */
@XmlRootElement
@XmlAccessorType( XmlAccessType.NONE)
public class Service {
	private Long id;
	private String name;
	private ServiceDataCollection data;
	private Double cost;
	private Double vat;


	@XmlAttribute
	public Long getId() {
		return id;
	}


	public void setId( Long id ) {
		this.id = id;
	}


	@XmlAttribute
	public String getName() {
		return name;
	}


	public void setName( String name ) {
		this.name = name;
	}


	@XmlElement(name = "properties")
	public ServiceDataCollection getData() {
		return data;
	}


	public void setData( ServiceDataCollection data ) {
		this.data = data;
	}


	@XmlElement
	public Double getCost() {
		return cost;
	}


	public void setCost( Double cost ) {
		this.cost = cost;
	}


	@XmlElement
	public Double getVat() {
		return vat;
	}


	public void setVat( Double vat ) {
		this.vat = vat;
	}
}