/**
 * 
 */
package com.afkl.cases.df.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author udayakumar.rajan
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "status", "code", "detail", "fares" })
public class Response {
	
	@JsonProperty("status")
	private String status;
	@JsonIgnore
	private HttpStatus code;
	@JsonProperty("detail")
	private String detail;
	@JsonProperty("fares")
	private List <FareResult> fares = new ArrayList<FareResult>();

	/**
	 * @return the status
	 */
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the code
	 */
	@JsonIgnore
	public HttpStatus getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	@JsonIgnore
	public void setCode(HttpStatus code) {
		this.code = code;
	}

	/**
	 * @return the detail
	 */
	@JsonProperty("detail")
	public String getDetail() {
		return detail;
	}

	/**
	 * @param detail the detail to set
	 */
	@JsonProperty("detail")
	public void setDetail(String detail) {
		this.detail = detail;
	}

	/**
	 * @return the fares
	 */
	@JsonProperty("fares")
	public List<FareResult> getFares() {
		return fares;
	}

	/**
	 * @param fares the fares to set
	 */
	@JsonProperty("fares")
	public void setFares(List<FareResult> fares) {
		this.fares = fares;
	}
	
	
	
	

}
