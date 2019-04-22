/**
 * 
 */
package com.afkl.cases.df.statistics.service;

import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.afkl.cases.df.model.Statistics;

/**
 * @author Udayakumar.Rajan
 *
 */
@Service
public class StatisticsService {

	private ConcurrentMap<String, Integer> statusMap = new ConcurrentHashMap<>();
	private Map<String, Integer> timeStamp = new TreeMap <>();
	
	
	
	@PostConstruct
	public void init() throws IOException { 
		
	}
	
	

	/**
	 * To track the status and the hit count of any service from the server.
	 * @param httpMethod
	 * @param uri
	 * @param status
	 */
	public void increaseCount(String httpMethod, String uri, int status) {
	//	ConcurrentHashMap<Object, Integer> statusMap = metricMap.get(httpMethod+ ":"+uri);
		if (statusMap == null) {
			statusMap = new ConcurrentHashMap<>();
		}
		
		
		
		if ("/travel/statistics_data".equals(uri) || uri.endsWith(".js") || uri.endsWith(".jpg") || uri.endsWith(".css"))
			return;
		Integer count = statusMap.get(String.valueOf(status));
		if (count == null) {
			count = 1;
		} else {
			count++;
		}
		statusMap.put(String.valueOf(status), count);
		//metricMap.put(httpMethod+ ":"+uri, statusMap);
		
		Integer totalCount = statusMap.get("total");
		if (totalCount == null) {
			totalCount = 1;
		} else {
			totalCount++;
		}
		statusMap.put("total", totalCount);
	}

	public List<Statistics> getFullStatistics() {
		long start = System.currentTimeMillis(); 
		List<Statistics> statisticsList = new ArrayList<>();
		String summaryText = "Total number of requests resulted in {0} Response";
		statusMap.entrySet().stream().forEachOrdered(entry-> {
			Statistics statistics = new Statistics();
				String key =  entry.getKey();
				statistics.setMethodType(key.equals("total") ? "Total number of requests processed" : MessageFormat.format(summaryText, entry.getKey()));
				statistics.setCount(entry.getValue());
				statisticsList.add(statistics);
		});
		
		long end = System.currentTimeMillis() - start;
		timeStamp.put(LocalDateTime.now().toString(), Long.valueOf(end).intValue());
		List<Integer> responseTimes = new ArrayList<>();
		responseTimes.addAll(timeStamp.values());
		Collections.sort(responseTimes);
		int min = responseTimes.get(0);
		int max =  responseTimes.get(responseTimes.size()-1);
		int avg = responseTimes.stream().mapToInt(val -> val.intValue()).sum() / responseTimes.size();
		Statistics statistics = new Statistics();
		statistics.setMethodType("Min response time (ms) of all requests");
		statistics.setCount(min);
		statisticsList.add(statistics);
		
		statistics = new Statistics();
		statistics.setMethodType("Max response time (ms) of all requests");
		statistics.setCount(max);
		statisticsList.add(statistics);
		
		statistics = new Statistics();
		statistics.setMethodType("Avg. response time (ms) of all requests");
		statistics.setCount(avg);
		statisticsList.add(statistics);
		
		return statisticsList;
	}
	
	/**
	 * 
	 * @param uniqueId
	 * @param time
	 */
	public void addResponseTime (String uniqueId , int time) {
		timeStamp.put(uniqueId + ":" + LocalDateTime.now().toString(), time);
	}
	
}