package com.skilldistillery.fuelmileage.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "fuel")
public class Fuel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

//	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "date")
	private Date date;

	@Column(name = "gallons")
	private Double gallons;

	@Column(name = "price_per_gallon")
	private Double pricePerGallon;

	@Column(name = "total_purchase_price")
	private Double totalPrice;

	@Column(name = "estimated_miles")
	private Integer estimatedMiles;

	@Column(name = "odometer_reading")
	private int odometerReading;

	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getGallons() {
		return gallons;
	}

	public void setGallons(Double gallons) {
		this.gallons = gallons;
	}

	public Double getPricePerGallon() {
		return pricePerGallon;
	}

	public void setPricePerGallon(Double pricePerGallon) {
		this.pricePerGallon = pricePerGallon;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getEstimatedMiles() {
		return estimatedMiles;
	}

	public void setEstimatedMiles(Integer estimatedMiles) {
		this.estimatedMiles = estimatedMiles;
	}

	public int getOdometerReading() {
		return odometerReading;
	}

	public void setOdometerReading(int odometerReading) {
		this.odometerReading = odometerReading;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Fuel [id=");
		builder.append(id);
		builder.append(", date=");
		builder.append(date);
		builder.append(", gallons=");
		builder.append(gallons);
		builder.append(", pricePerGallon=");
		builder.append(pricePerGallon);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append(", estimatedMiles=");
		builder.append(estimatedMiles);
		builder.append(", odometerReading=");
		builder.append(odometerReading);
		builder.append(", vehicle=");
		builder.append(vehicle);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((estimatedMiles == null) ? 0 : estimatedMiles.hashCode());
		result = prime * result + ((gallons == null) ? 0 : gallons.hashCode());
		result = prime * result + id;
		result = prime * result + odometerReading;
		result = prime * result + ((pricePerGallon == null) ? 0 : pricePerGallon.hashCode());
		result = prime * result + ((totalPrice == null) ? 0 : totalPrice.hashCode());
		result = prime * result + ((vehicle == null) ? 0 : vehicle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fuel other = (Fuel) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (estimatedMiles == null) {
			if (other.estimatedMiles != null)
				return false;
		} else if (!estimatedMiles.equals(other.estimatedMiles))
			return false;
		if (gallons == null) {
			if (other.gallons != null)
				return false;
		} else if (!gallons.equals(other.gallons))
			return false;
		if (id != other.id)
			return false;
		if (odometerReading != other.odometerReading)
			return false;
		if (pricePerGallon == null) {
			if (other.pricePerGallon != null)
				return false;
		} else if (!pricePerGallon.equals(other.pricePerGallon))
			return false;
		if (totalPrice == null) {
			if (other.totalPrice != null)
				return false;
		} else if (!totalPrice.equals(other.totalPrice))
			return false;
		if (vehicle == null) {
			if (other.vehicle != null)
				return false;
		} else if (!vehicle.equals(other.vehicle))
			return false;
		return true;
	}

	public Fuel() {
		super();
	}

}
