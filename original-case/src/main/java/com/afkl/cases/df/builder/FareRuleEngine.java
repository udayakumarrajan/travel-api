/**
 * 
 */
package com.afkl.cases.df.builder;

import java.util.List;

import org.eclipse.jetty.util.Callback.Completable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.afkl.cases.df.model.FareResult;
import com.afkl.cases.df.model.SearchParam;
import com.afkl.cases.df.model.flight.Flight;
import com.afkl.cases.df.service.FareService;
import com.afkl.cases.df.service.FlightService;
import com.afkl.cases.df.statistics.service.StatisticsService;

/**
 * @author Udayakumar.Rajan
 *
 */
@Component
public class FareRuleEngine {

	private static final Logger logger = LoggerFactory.getLogger(FareRuleEngine.class);
	
	
	@Autowired
	private StatisticsService statisticsService;

	private FlightService flightService;

	private FareService fareService;

	private SearchParam searchParam;

	@Autowired
	public FareRuleEngine(FlightService flightService, FareService fareService) {
		this.flightService = flightService;
		this.fareService = fareService;
	}

	/**
	 * Hold the search param and pass them into filter and get the matched fares
	 * 
	 * @param searchParam
	 */
	public void with(SearchParam searchParam) {
		this.searchParam = searchParam;
	}

	/**
	 * Fare filter engine to get the fares from mock data.
	 * @return
	 */
	public List<FareResult> get() {
		String uniqueId = searchParam.getSecurityGUID();
		logger.debug("id -> {} ::::  searching for result", uniqueId);
		StringBuffer logBuffer = new StringBuffer();
		String origin = searchParam.getOrigin();
		String dest = searchParam.getDestination();
		String depart = searchParam.getDepart();
		logBuffer.append(" [Origin : ").append(origin).append(", Destination : ").append(dest).append(", Date : ")
				.append(depart).append("]");
		logger.info("id -> {} ::::   Request received to search fares for {}",uniqueId,logBuffer.toString());
		long start = System.currentTimeMillis();
		List<Flight> matchedFlights = flightService.with(uniqueId, origin, dest, depart).filter();
		List<FareResult> response = fareService.with(matchedFlights, searchParam).filter();
		long end = System.currentTimeMillis() - start;
		recordResponseTime(uniqueId, end);
		logger.info("id -> {} :::: Done!. Total Time taken for {} {} {} ",uniqueId, logBuffer.toString(), end, "ms");
		return response;
	}
	
	/**
	 * 
	 * @param uniqueId
	 * @param time
	 */
	private void recordResponseTime (String uniqueId, Long time) {
		Completable.runAsync(new Runnable() {
			
			@Override
			public void run() {
				logger.info("id -> {} :::: updating response time in async......", uniqueId);
				logger.info("async-task-thread_id{{}} ", Thread.currentThread().getId());
				statisticsService.addResponseTime(uniqueId, time.intValue());
				
			}
		});
	}

}
