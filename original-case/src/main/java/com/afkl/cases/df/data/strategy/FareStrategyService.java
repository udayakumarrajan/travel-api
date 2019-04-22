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
import com.afkl.cases.df.model.fare.RouteFare;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * @author Udayakumar.Rajan
 *
 */
@Component("fares")
public class FareStrategyService  implements BookingStrategyService<RouteFare> {
	
	private static final Logger logger = LoggerFactory.getLogger(BookingStrategyService.class);
	
	@Autowired
	private FileReader<RouteFare> fileLoader;
	
	private List <RouteFare> fares = new ArrayList<>();
	
	@Value("${fares.mock.file.path}")
	private String filePath;

	@Override
	@PostConstruct
	public void loadFile() {
		try {
			logger.debug("airport mock file path {}", filePath);
			fares =  fileLoader.loadFile(filePath, new TypeReference<List<RouteFare>>() {
			});
			logger.info("airports are loaded from mock file....");
		} catch (IOException e) {
			logger.error("unable to load airport mock file {}", e);
		}
		
	}
	
	@Override
	public List<RouteFare> getData() {
		return fares;
	}

}
