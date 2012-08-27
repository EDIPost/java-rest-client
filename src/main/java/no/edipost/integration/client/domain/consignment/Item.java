package no.edipost.integration.client.domain.consignment;


import javax.xml.bind.annotation.XmlRootElement;


/**
 * An Item represents a physical package in a {@link Consignment}. A consignment will always consist of one or more items
 *
 * @author Mathias Bjerke
 */
@XmlRootElement
public class Item {
	private String connoteNumber;
	private Double weight;
	private Double height;
	private Double width;
	private Double length;
	private Double cost;
	private Double vat;


	public Item() {
	}


	public Item( Double weight, Double height, Double width, Double length ) {
		this.weight = weight;
		this.height = height;
		this.width = width;
		this.length = length;
	}


	public String getConnoteNumber() {
		return connoteNumber;
	}


	public void setConnoteNumber( String connoteNumber ) {
		this.connoteNumber = connoteNumber;
	}


	public Double getWeight() {
		return weight;
	}


	public void setWeight( Double weight ) {
		this.weight = weight;
	}


	public Double getHeight() {
		return height;
	}


	public void setHeight( Double height ) {
		this.height = height;
	}


	public Double getWidth() {
		return width;
	}


	public void setWidth( Double width ) {
		this.width = width;
	}


	public Double getLength() {
		return length;
	}


	public void setLength( Double length ) {
		this.length = length;
	}


	public Double getCost() {
		return cost;
	}


	public void setCost( Double cost ) {
		this.cost = cost;
	}


	public Double getVat() {
		return vat;
	}


	public void setVat( Double vat ) {
		this.vat = vat;
	}
}
