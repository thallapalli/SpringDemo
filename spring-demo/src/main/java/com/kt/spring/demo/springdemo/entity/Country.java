package com.kt.spring.demo.springdemo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the COUNTRIES database table.
 * 
 */
@Entity
@Table(name="COUNTRIES")
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COUNTRY_ID", unique=true, nullable=false, length=2)
	private String countryId;

	@Column(name="COUNTRY_NAME", length=40)
	private String countryName;

	//bi-directional many-to-one association to Region
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="REGION_ID")
	private Region region;

	//bi-directional many-to-one association to Location
	@OneToMany(mappedBy="country")
	private List<Location> locations;

	public Country() {
	}

	public String getCountryId() {
		return this.countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public Location addLocation(Location location) {
		getLocations().add(location);
		location.setCountry(this);

		return location;
	}

	public Location removeLocation(Location location) {
		getLocations().remove(location);
		location.setCountry(null);

		return location;
	}

}