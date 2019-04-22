/**
 * 
 */
package com.afkl.cases.df.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.afkl.cases.df.builder.FareSearchBuilder;
import com.afkl.cases.df.model.FareResult;
import com.afkl.cases.df.model.Response;
import com.afkl.cases.df.model.SearchParam;

import io.swagger.annotations.ApiOperation;


/**
 * @author Udayakumar.Rajan
 *
 */
@RestController
public class FareController {
	
	private static final Logger logger = LoggerFactory.getLogger(FareController.class);
	
	@Autowired
	private FareSearchBuilder fareSearch;
	
	/**
	 * Based on the user search input, it will search and list the fares
	 * @param searchModel
	 * @return
	 */
	@PostMapping(value = "/searchFares")
	@ApiOperation(value = "Return Fares for matching search criteria.", response = FareResult.class)
    public ResponseEntity<Response> searchAirports(@RequestBody SearchParam  param) {
		String securityGUID = param.getSecurityGUID();
		if (StringUtils.isEmpty(securityGUID))  {
			securityGUID = UUID.randomUUID().toString();
			param.setSecurityGUID(securityGUID);
		}
		logger.info("id -> {} :::: request received. in-progress to fetch matching fares", securityGUID);
		Response response = fareSearch.with(param).get();
		return new ResponseEntity<>(response, response.getCode());
    }

}