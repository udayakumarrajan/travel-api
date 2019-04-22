package com.afkl.cases.df.model.fare;

import java.util.HashMap;
import java.util.List;
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
@JsonPropertyOrder({ "id", "economyFare", "businessFare", "firtClassFare", "faresApplicableDate", "applicableFlights", "currencyCode" })
public class RouteFare {

	@JsonProperty("id")
	private String id;
	@JsonProperty("economyFare")
	private String economyFare;
	@JsonProperty("businessFare")
	private String businessFare;
	@JsonProperty("firtClassFare")
	private Double firtClassFare;
	@JsonProperty("faresApplicableDate")
	private FaresApplicableDate faresApplicableDate;
	@JsonProperty("applicableFlights")
	private List<Integer> applicableFlights = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	@JsonProperty ("currencyCode")
	private String currencyCode;

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("economyFare")
	public String getEconomyFare() {
		return economyFare;
	}

	@JsonProperty("economyFare")
	public void setEconomyFare(String economyFare) {
		this.economyFare = economyFare;
	}

	@JsonProperty("businessFare")
	public String getBusinessFare() {
		return businessFare;
	}

	@JsonProperty("businessFare")
	public void setBusinessFare(String businessFare) {
		this.businessFare = businessFare;
	}

	@JsonProperty("firtClassFare")
	public Double getFirtClassFare() {
		return firtClassFare;
	}

	@JsonProperty("firtClassFare")
	public void setFirtClassFare(Double firtClassFare) {
		this.firtClassFare = firtClassFare;
	}

	@JsonProperty("faresApplicableDate")
	public FaresApplicableDate getFaresApplicableDate() {
		return faresApplicableDate;
	}

	@JsonProperty("faresApplicableDate")
	public void setFaresApplicableDate(FaresApplicableDate faresApplicableDate) {
		this.faresApplicableDate = faresApplicableDate;
	}

	@JsonProperty("applicableFlights")
	public List<Integer> getApplicableFlights() {
		return applicableFlights;
	}

	@JsonProperty("applicableFlights")
	public void setApplicableFlights(List<Integer> applicableFlights) {
		this.applicableFlights = applicableFlights;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
	@JsonProperty ("currencyCode")
	public String getCurrencyCode() {
		return currencyCode;
	}
	@JsonProperty ("currencyCode")
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	

}