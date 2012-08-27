package no.edipost.integration.client.domain;


import no.edipost.integration.client.domain.service.Service;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


/**
 * Product represents a sending method at the {@link Transporter}. Examples of delivery methods are cargo, express, couriers, etc
 *
 * @author Mathias Bjerke
 */
@XmlRootElement
public class Product {
	private Integer id;
	private String name;
	private Transporter transporter;
	private String status;
	private List<Service> services;


	@XmlAttribute
	public Integer getId() {
		return id;
	}


	public void setId( Integer id ) {
		this.id = id;
	}


	@XmlAttribute
	public String getName() {
		return name;
	}


	public void setName( String name ) {
		this.name = name;
	}


	public Transporter getTransporter() {
		return transporter;
	}


	public void setTransporter( Transporter transporter ) {
		this.transporter = transporter;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus( String status ) {
		this.status = status;
	}


	@XmlElement(name = "service")
	public List<Service> getServices() {
		return services;
	}


	public void setServices( List<Service> services ) {
		this.services = services;
	}
}
