/**
 * 
 */
package com.afkl.cases.df.data.strategy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.afkl.cases.df.data.loader.FileReader;
import com.afkl.cases.df.model.airport.Airport;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * @author udayakumar.rajan
 * @param <Airport>
 *
 */
@Component ("airports")
public class AirportStrategyService implements BookingStrategyService<Airport> {
	
	private static final Logger logger = LoggerFactory.getLogger(BookingStrategyService.class);

	
	@Autowired
	private FileReader<Airport> fileLoader;
	
	private List <Airport> airports = new ArrayList<>();
	
	@Value("${airport.mock.file.path}")
	private String filePath;
	
	/**
	 * 
	 */
	@Override
	@PostConstruct
	public void loadFile() {
		try {
			logger.debug("airport mock file path {}", filePath);
			airports =  fileLoader.loadFile(filePath, new TypeReference<List<Airport>>() {
			});
			logger.info("airports are loaded from mock file....");
		} catch (IOException e) {
			logger.error("unable to load airport mock file {}", e);
		}
	}
	
	/**
	 * 
	 */
	@Override
	public List<Airport> getData() {
		return airports;
	}
	
	/**
	 * 
	 */
	@Override
	public List<Airport> filter(String param) {
		String aptCode = param.toLowerCase();
		return airports.stream().filter(airport -> airport.getCode().toLowerCase().contains(aptCode)
				|| airport.getName().toLowerCase().contains(aptCode)).collect(Collectors.toList());
	}

}
