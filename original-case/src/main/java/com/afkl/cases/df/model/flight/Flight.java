/**
 * 
 */
package com.afkl.cases.df.model.flight;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 
 * @author Udayakumar.Rajan
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "origin", "destination", "departureDate", "carrierCode", "flightNumber", "flightTime",
		"departTime", "arrivalTime", "validBetween" })
public class Flight {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("origin")
	private String origin;
	@JsonProperty("destination")
	private String destination;
	@JsonProperty("departureDate")
	private String departureDate;
	@JsonProperty("carrierCode")
	private String carrierCode;
	@JsonProperty("flightNumber")
	private String flightNumber;
	@JsonProperty("flightTime")
	private String flightTime;
	@JsonProperty("departTime")
	private String departTime;
	@JsonProperty("arrivalTime")
	private String arrivalTime;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	@JsonProperty("validBetween")
	private ValidBetween validBetween;

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("origin")
	public String getOrigin() {
		return origin;
	}

	@JsonProperty("origin")
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@JsonProperty("destination")
	public String getDestination() {
		return destination;
	}

	@JsonProperty("destination")
	public void setDestination(String destination) {
		this.destination = destination;
	}

	@JsonProperty("departureDate")
	public String getDepartureDate() {
		return departureDate;
	}

	@JsonProperty("departureDate")
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	@JsonProperty("carrierCode")
	public String getCarrierCode() {
		return carrierCode;
	}

	@JsonProperty("carrierCode")
	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	@JsonProperty("flightNumber")
	public String getFlightNumber() {
		return flightNumber;
	}

	@JsonProperty("flightNumber")
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	@JsonProperty("flightTime")
	public String getFlightTime() {
		return flightTime;
	}

	@JsonProperty("flightTime")
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}

	@JsonProperty("departTime")
	public String getDepartTime() {
		return departTime;
	}

	@JsonProperty("departTime")
	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	@JsonProperty("arrivalTime")
	public String getArrivalTime() {
		return arrivalTime;
	}

	@JsonProperty("arrivalTime")
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@JsonProperty("validBetween")
	public ValidBetween getValidBetween() {
		return validBetween;
	}

	@JsonProperty("validBetween")
	public void setValidBetween(ValidBetween validBetween) {
		this.validBetween = validBetween;
	}

}