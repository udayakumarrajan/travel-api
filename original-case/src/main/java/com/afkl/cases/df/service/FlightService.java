/**
 * 
 */
package com.afkl.cases.df.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.afkl.cases.df.data.strategy.BookingStrategyService;
import com.afkl.cases.df.model.flight.Flight;
import com.afkl.cases.df.model.flight.ValidBetween;

/**
 * @author Udayakumar.Rajan
 *
 */
@Service
public class FlightService {

	private static final Logger logger = LoggerFactory.getLogger(FlightService.class);

	@Autowired
	@Qualifier("flights")
	private BookingStrategyService<Flight> strategy;

	private SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");

	private String origin;
	private String destination;
	private String departure;
	private String securityGUID;

	/**
	 * 
	 * @return
	 */
	public List<Flight> getFlights() {
		return strategy.getData();
	}

	/**
	 * 
	 * @param origin
	 * @param destination
	 * @param departure
	 * @return
	 */
	public FlightService with(String securityGUID, String origin, String destination, String departure) {
		this.origin = origin;
		this.destination = destination;
		this.departure = departure;
		this.securityGUID = securityGUID;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public List<Flight> filter() {
		return getFlights().stream().filter(flt -> flt.getOrigin().equals(origin)
				&& flt.getDestination().equals(destination) && isDateBetween(departure, flt.getValidBetween()))
				.collect(Collectors.toList());
	}

	/**
	 * 
	 * @param searchDate
	 * @param between
	 * @return
	 */
	private boolean isDateBetween(String searchDate, ValidBetween between) {
		Date start = between.getStart();
		Date end = between.getEnd();
		try {
			Date departDate = dateformat.parse(searchDate);
			return departDate.compareTo(start) >= 0 && departDate.compareTo(end) <= 0;
		} catch (ParseException e) {
			logger.error("id -> {} :::: Unable to find the time difference {}", securityGUID, e);
		}
		return false;
	}

}
