/**
 * 
 */
package com.afkl.cases.df.builder;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.afkl.cases.df.model.Response;
import com.afkl.cases.df.model.SearchParam;
import com.afkl.cases.df.statistics.service.TravelApiConstant;


/**
 * @author Udayakumar.Rajan
 *
 */
@Service
public class FareSearchBuilder {
	
	private static final Logger logger = LoggerFactory.getLogger(FareSearchBuilder.class);
	
	@Autowired
	private FareRuleEngine ruleEngine;

	private SearchParam param;

	/**
	 * To pass the the input param to rule engine.
	 * @param param
	 * @return
	 */
	public FareSearchBuilder with(SearchParam param) {
		logger.debug("search param :: {}", param);
		this.param = param;
		logger.info("id -> {} :::: passing the param to fare rule engin", param.getSecurityGUID());
		ruleEngine.with(param);
		return this;
	}
	
	/**
	 * To get the matching results from Fare mock 
	 * @return
	 */
	public Response get () {
		logger.debug("id -> {} ::::  find the fares for requested search ", param.getSecurityGUID());
		Response response = new Response();
		response.setStatus(TravelApiConstant.SUCCESS);
		response.setCode(HttpStatus.OK);
		if (!isValidate()) {
			logger.debug("id -> {} ::::  its not valid request to process -> {}", param.getSecurityGUID(), param);
			response.setStatus(TravelApiConstant.FAIL);
			response.setDetail(TravelApiConstant.ERR_MSG);
			response.setCode(HttpStatus.BAD_REQUEST);
			return response;
		}
		response.setFares(ruleEngine.get());
		return response;
	}

	/**
	 * 
	 * @return
	 */
	private boolean isValidate() {
		if (StringUtils.isEmpty(param.getOrigin())|| StringUtils.isEmpty(param.getDestination())
				|| StringUtils.isEmpty(param.getDepart())) {
			return false;
		}
		return true;
		
	}
	
}
