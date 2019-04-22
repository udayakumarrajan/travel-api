/**
 * 
 */
package com.afkl.cases.df.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.afkl.cases.df.data.strategy.BookingStrategyService;
import com.afkl.cases.df.model.airport.Airport;

/**
 * @author Udayakumar.Rajan
 *
 */
@Service
public class AirportService  {
	
	@Autowired
	@Qualifier("airports")
	private BookingStrategyService<Airport> strategy;
	
	/**
	 * To return the list of airports.
	 * @return
	 */
    public List<Airport> getAirports () {
    		return strategy.getData();
    }
	
    /**
     * To search the airport details based the text entered by user.
     * @param filter
     * @return
     */
	public List<Airport> searchAirports (String filter) {
		return strategy.filter(filter);

	}

}
