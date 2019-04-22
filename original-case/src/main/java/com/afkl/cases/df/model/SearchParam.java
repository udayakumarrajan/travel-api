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
 * @author Udayakumar.rajan
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "securityGUID", "origin", "destination", "depart", "arrival", "adultCount", "childCount", "cabin", "originDesc",
		"destDesc" })
public class SearchParam {

	@JsonProperty("origin")
	private String origin;
	@JsonProperty("destination")
	private String destination;
	@JsonProperty("depart")
	private String depart;
	@JsonProperty("arrival")
	private String arrival;
	@JsonProperty("adultCount")
	private Integer adultCount;
	@JsonProperty("childCount")
	private Integer childCount;
	@JsonProperty("cabin")
	private String cabin;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	@JsonProperty("originDesc")
	private String originDesc;
	@JsonProperty("destDesc")
	private String destDesc;
	@JsonProperty ("securityGUID")
	private String securityGUID;

	@JsonProperty("origin")
	public String getOrigin() {
		return origin;
	}

	@JsonProperty("origin")
	public void setOrgin(String origin) {
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

	@JsonProperty("depart")
	public String getDepart() {
		return depart;
	}

	@JsonProperty("depart")
	public void setDepart(String depart) {
		this.depart = depart;
	}

	@JsonProperty("arrival")
	public String getArrival() {
		return arrival;
	}

	@JsonProperty("arrival")
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	@JsonProperty("adultCount")
	public Integer getAdultCount() {
		return adultCount;
	}

	@JsonProperty("adultCount")
	public void setAdultCount(Integer adultCount) {
		this.adultCount = adultCount;
	}

	@JsonProperty("childCount")
	public Integer getChildCount() {
		return childCount;
	}

	@JsonProperty("childCount")
	public void setChildCount(Integer childCount) {
		this.childCount = childCount;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	/**
	 * @return the cabin
	 */
	@JsonProperty("cabin")
	public String getCabin() {
		return cabin;
	}

	/**
	 * @param cabin
	 *            the cabin to set
	 */
	@JsonProperty("cabin")
	public void setCabin(String cabin) {
		this.cabin = cabin;
	}

	@JsonProperty("destDesc")
	public String getDestDesc() {
		return destDesc;
	}

	@JsonProperty("destDesc")
	public void setDestDesc(String destDesc) {
		this.destDesc = destDesc;
	}

	@JsonProperty("originDesc")
	public String getOriginDesc() {
		return originDesc;
	}

	@JsonProperty("originDesc")
	public void setOriginDesc(String originDesc) {
		this.originDesc = originDesc;
	}
	
	

	/**
	 * @return the securityGUID
	 */
	@JsonProperty ("securityGUID")
	public String getSecurityGUID() {
		return securityGUID;
	}

	/**
	 * @param securityGUID the securityGUID to set
	 */
	@JsonProperty ("securityGUID")
	public void setSecurityGUID(String securityGUID) {
		this.securityGUID = securityGUID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SearchParam [origin=" + origin + ", destination=" + destination + ", depart=" + depart + ", arrival="
				+ arrival + ", adultCount=" + adultCount + ", childCount=" + childCount + ", cabin=" + cabin
				+ ", additionalProperties=" + additionalProperties + ", originDesc=" + originDesc + ", destDesc="
				+ destDesc + ", securityGUID=" + securityGUID + "]";
	}

	
	

}