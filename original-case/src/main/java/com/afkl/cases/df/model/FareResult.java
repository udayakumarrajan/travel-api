/**
 * 
 */
package com.afkl.cases.df.model;

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
@JsonPropertyOrder({ "origin", "destination", "departure", "arrival", "flightNumber", "economyFare", "businessFare",
		"totalJouneryTime", "departTime", "arrivalTime" })
public class FareResult {

	@JsonProperty("origin")
	private String origin;
	@JsonProperty("destination")
	private String destination;
	@JsonProperty("departure")
	private String departure;
	@JsonProperty("arrival")
	private String arrival;
	@JsonProperty("flightNumber")
	private String flightNumber;
	@JsonProperty("economyFare")
	private String economyFare;
	@JsonProperty("businessFare")
	private String businessFare;
	@JsonProperty("totalJouneryTime")
	private String totalJouneryTime;
	@JsonProperty("departTime")
	private String departTime;
	@JsonProperty("arrivalTime")
	private String arrivalTime;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

	@JsonProperty("departure")
	public String getDeparture() {
		return departure;
	}

	@JsonProperty("departure")
	public void setDeparture(String departure) {
		this.departure = departure;
	}

	@JsonProperty("arrival")
	public String getArrival() {
		return arrival;
	}

	@JsonProperty("arrival")
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	@JsonProperty("flightNumber")
	public String getFlightNumber() {
		return flightNumber;
	}

	@JsonProperty("flightNumber")
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	@JsonProperty("businessFare")
	public String getBusinessFare() {
		return businessFare;
	}

	@JsonProperty("businessFare")
	public void setBusinessFare(String businessFare) {
		this.businessFare = businessFare;
	}

	@JsonProperty("economyFare")
	public String getEconomyFare() {
		return economyFare;
	}

	@JsonProperty("fare")
	public void setEconomyFare(String economyFare) {
		this.economyFare = economyFare;
	}

	@JsonProperty("totalJouneryTime")
	public String getTotalJouneryTime() {
		return totalJouneryTime;
	}

	@JsonProperty("totalJouneryTime")
	public void setTotalJouneryTime(String totalJouneryTime) {
		this.totalJouneryTime = totalJouneryTime;
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

}
