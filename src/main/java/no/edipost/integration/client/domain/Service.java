package no.edipost.integration.client.domain;


import javax.xml.bind.annotation.*;
import java.util.List;


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
	private List<Parameter> serviceParameters;


	public Service() {
		data = new ServiceDataCollection();
	}


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
		if( data.getEntries().size() <= 0 )
			return null;
		else
			return data;
	}


	public void setData( ServiceDataCollection data ) {
		this.data = data;
	}


	public ServiceData getServiceDataByName( String serviceDataName ) {
		for( ServiceData serviceData : data.getEntries() ) {
			if( serviceData.getKey() != null && serviceData.getKey().equals( serviceDataName ) ) return serviceData;
		}

		return null;
	}


	public void addData( ServiceData data ) {
		this.data.addEntry( data );
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


	public List<Parameter> getServiceParameters() {
		return serviceParameters;
	}


	public void setServiceParameters( List<Parameter> serviceParameters ) {
		this.serviceParameters = serviceParameters;
	}


	@Override
	public String toString() {
		return "Service with ID: " + id;
	}
}