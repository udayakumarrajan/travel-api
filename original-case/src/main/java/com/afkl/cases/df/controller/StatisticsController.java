/**
 * 
 */
package com.afkl.cases.df.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.afkl.cases.df.model.Statistics;
import com.afkl.cases.df.statistics.service.StatisticsService;

/**
 * @author Udayakumar.Rajan
 *
 */
@RestController
public class StatisticsController {
	@Autowired
	 private StatisticsService statisticsService;
	
	@GetMapping(value = "/statistics_data", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Statistics> getStatistics() {
	    return statisticsService.getFullStatistics();
	}
	
}
