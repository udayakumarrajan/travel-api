/**
 * 
 */
package com.afkl.cases.df.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.afkl.cases.df.model.airport.Airport;
import com.afkl.cases.df.service.AirportService;


/**
 * @author Udayakumar.rajan
 *
 */
@RestController
public class AirportController {

	@Autowired
	private AirportService service;

	private static Logger logger = LoggerFactory.getLogger(AirportController.class);

	/**
	 * To get the Airport information from json file.
	 * 
	 * @return
	 */
	@GetMapping(value = "/getAirports")
	public ResponseEntity<List<Airport>> getAirports() {
		logger.debug("request received to retrive all the airports");
		return new ResponseEntity<>(service.getAirports(), HttpStatus.OK);
	}

	/**
	 * To search and get the matched airport/ Airport names.
	 * 
	 * @param filter
	 * @return
	 */
	@PostMapping(value = "/searchAirports")
	public ResponseEntity<List<Airport>> searchAirports(@RequestParam(value = "filter") String filter) {
		logger.debug("request received to retrive to get airport {}", filter);
		return new ResponseEntity<>(service.searchAirports(filter), HttpStatus.CREATED);
	}
}
