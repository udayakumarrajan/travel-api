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
@JsonPropertyOrder({ "URI", "methodType", "statusCode", "count", "minTime", "maxTime", "avgTime", "refId", "date" })
public class Statistics {

	@JsonProperty("URI")
	private String uRI;
	@JsonProperty("methodType")
	private String methodType;
	@JsonProperty("statusCode")
	private String statusCode;
	@JsonProperty("count")
	private Integer count;
	@JsonProperty("minTime")
	private Integer minTime;
	@JsonProperty("maxTime")
	private Integer maxTime;
	@JsonProperty("avgTime")
	private Double avgTime;
	@JsonProperty("refId")
	private String refId;
	@JsonProperty("date")
	private String date;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("URI")
	public String getURI() {
		return uRI;
	}

	@JsonProperty("URI")
	public void setURI(String uRI) {
		this.uRI = uRI;
	}

	@JsonProperty("methodType")
	public String getMethodType() {
		return methodType;
	}

	@JsonProperty("methodType")
	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}

	@JsonProperty("statusCode")
	public String getStatusCode() {
		return statusCode;
	}

	@JsonProperty("statusCode")
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	@JsonProperty("count")
	public Integer getCount() {
		return count;
	}

	@JsonProperty("count")
	public void setCount(Integer count) {
		this.count = count;
	}

	@JsonProperty("minTime")
	public Integer getMinTime() {
		return minTime;
	}

	@JsonProperty("minTime")
	public void setMinTime(Integer minTime) {
		this.minTime = minTime;
	}

	@JsonProperty("maxTime")
	public Integer getMaxTime() {
		return maxTime;
	}

	@JsonProperty("maxTime")
	public void setMaxTime(Integer maxTime) {
		this.maxTime = maxTime;
	}

	@JsonProperty("avgTime")
	public Double getAvgTime() {
		return avgTime;
	}

	@JsonProperty("avgTime")
	public void setAvgTime(Double avgTime) {
		this.avgTime = avgTime;
	}

	@JsonProperty("refId")
	public String getRefId() {
		return refId;
	}

	@JsonProperty("refId")
	public void setRefId(String refId) {
		this.refId = refId;
	}

	@JsonProperty("date")
	public String getDate() {
		return date;
	}

	@JsonProperty("date")
	public void setDate(String date) {
		this.date = date;
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