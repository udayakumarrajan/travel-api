/**
 * 
 */
package com.afkl.cases.df.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.afkl.cases.df.data.strategy.BookingStrategyService;
import com.afkl.cases.df.model.FareResult;
import com.afkl.cases.df.model.SearchParam;
import com.afkl.cases.df.model.fare.RouteFare;
import com.afkl.cases.df.model.flight.Flight;

/**
 * @author Udayakumar.Rajan
 *
 */
@Service
public class FareService {
	
	@Autowired
	@Qualifier("fares")
	private BookingStrategyService<RouteFare> strategy;
	
	private List<Flight> flights;
	
	private SearchParam searchParam;
	
	
	/**
	 * 
	 * @return
	 */
	public List<RouteFare> getRouteFare() {
		return strategy.getData();
	}
	
	
	public FareService with (List <Flight> flights, SearchParam searchParam) {
		this.flights = flights;
		this.searchParam = searchParam;
		return this;
	}
	
	
	public List<FareResult> filter () {
		
		int adultCount = searchParam.getAdultCount() == null ? 1 : searchParam.getAdultCount();
		int childCount = searchParam.getChildCount() == null ? 0 : searchParam.getChildCount();
		int totalPax = adultCount + childCount;
		
		List<FareResult> fareResults = new ArrayList<>();
		flights.stream().forEach(flt -> {
			getRouteFare().stream().filter(fare -> fare.getApplicableFlights().contains(flt.getId()))
					.collect(Collectors.toList()).forEach(fare -> {
						
						FareResult fareResult = new FareResult();
						fareResults.add(fareResult);
						fareResult.setOrigin(searchParam.getOriginDesc());
						fareResult.setDestination(searchParam.getDestDesc());
						fareResult.setFlightNumber(flt.getCarrierCode() + flt.getFlightNumber());
						fareResult.setDeparture(searchParam.getDepart());
						fareResult.setTotalJouneryTime(flt.getFlightTime());
						fareResult.setDepartTime(flt.getDepartTime());
						fareResult.setArrivalTime(flt.getArrivalTime());
						fareResult.setEconomyFare(StringUtils.isEmpty(fare.getEconomyFare()) ? "No Seats"
								: fare.getCurrencyCode() + " " + Double.valueOf(fare.getEconomyFare())*totalPax);
						fareResult.setBusinessFare(StringUtils.isEmpty(fare.getBusinessFare()) ? "No Seats"
								: fare.getCurrencyCode() + " " + Double.valueOf(fare.getBusinessFare())*totalPax);

					});
		});
		return fareResults;
	} 
	

}
