/**
 * 
 */
package com.afkl.cases.df.statistics.filter;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.afkl.cases.df.statistics.service.StatisticsService;

/**
 * @author Udayakumar.Rajan
 *
 */
@Component
@WebFilter(filterName="StatisticsRecorder", urlPatterns= "/*")
public class StatisticsRecorder implements Filter {
	
	private static final Logger logger = LoggerFactory.getLogger(Filter.class);

	private StatisticsService statisticsService;

	@Override
	public void init(FilterConfig config) throws ServletException {
		statisticsService = (StatisticsService) WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext()).getBean("statisticsService");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws java.io.IOException, ServletException {
		logger.debug("request received in the filter");
		logger.info("async-task-thread_id{{}} ", Thread.currentThread().getId());
		HttpServletRequest httpRequest = ((HttpServletRequest) request);
		String uri = httpRequest.getRequestURI();

		chain.doFilter(request, response);

		int status = ((HttpServletResponse) response).getStatus();
		statisticsService.increaseCount(httpRequest.getMethod(), uri, status);
	}

	@Override
	public void destroy() {
		logger.info("Shutting down registered filter.........");

	}
}
