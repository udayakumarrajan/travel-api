/**
 * 
 */
package com.afkl.cases.df.data.strategy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.afkl.cases.df.data.loader.FileReader;
import com.afkl.cases.df.model.flight.Flight;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * 
 * @author udayakumar.rajan
 * @param <Flight>
 *
 */
@Component("flights")
public class FlightStrategyService implements BookingStrategyService<Flight> {

	private static final Logger logger = LoggerFactory.getLogger(BookingStrategyService.class);
	
	
	@Autowired
	private FileReader<Flight> fileLoader;
	
	@Value("${flight.mock.file.path}")
	private String filePath;
	
	private List<Flight> flights = new ArrayList<>();
	
	/**
	 * 
	 */
	@Override
	@PostConstruct
	public void loadFile() {
		try {
			logger.debug("Flight mock file path {}", filePath);
			flights =  fileLoader.loadFile(filePath, new TypeReference<List<Flight>>() {
			});
			logger.info("Flight are loaded from mock file....");
		} catch (IOException e) {
			logger.error("unable to load Flight mock file {}", e);
		}
	}
	
	@Override
	public List<Flight> getData() {
		return flights;
	}

}
