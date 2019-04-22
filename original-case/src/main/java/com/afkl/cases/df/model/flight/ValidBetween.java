/**
 * 
 */
package com.afkl.cases.df.model.flight;

import java.util.Date;
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
 * @author udayakumar.rajan
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "start", "end" })
public class ValidBetween {

	@JsonProperty("start")
	private Date start;
	@JsonProperty("end")
	private Date end;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("start")
	public Date getStart() {
		return start;
	}

	@JsonProperty("start")
	public void setStart(Date start) {
		this.start = start;
	}

	@JsonProperty("end")
	public Date getEnd() {
		return end;
	}

	@JsonProperty("end")
	public void setEnd(Date end) {
		this.end = end;
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
