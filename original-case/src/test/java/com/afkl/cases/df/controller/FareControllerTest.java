/**
 * 
 */
package com.afkl.cases.df.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.afkl.cases.df.Bootstrap;
import com.afkl.cases.df.model.Response;
import com.afkl.cases.df.model.SearchParam;

/**
 * @author udayakumar.rajan
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Bootstrap.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FareControllerTest {
	
	@LocalServerPort
	private int port;
	
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testFilterFares () {
		SearchParam param = new SearchParam();
		param.setOrgin("AMS");
		param.setDepart("2019/04/22");
		param.setDestination("DXB");
		
		HttpEntity<SearchParam> entity = new HttpEntity<SearchParam>(param, headers);
		
		ResponseEntity<Response> responseEnty = restTemplate.exchange(
				createURLWithPort("/searchFares"), HttpMethod.POST, entity,
				Response.class);
		assertThat(!responseEnty.getBody().getFares().isEmpty());
		
	}
	
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testFareswithInvalidAiport () {
		SearchParam param = new SearchParam();
		param.setOrgin("12");
		param.setDepart("2019/04/22");
		param.setDestination("DXB");
		
		HttpEntity<SearchParam> entity = new HttpEntity<SearchParam>(param, headers);
		
		ResponseEntity<Response> responseEnty = restTemplate.exchange(
				createURLWithPort("/searchFares"), HttpMethod.POST, entity,
				Response.class);
		assertThat(responseEnty.getBody().getFares().isEmpty());
		
	}
	
	
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testFareswithInvaliDate () {
		SearchParam param = new SearchParam();
		param.setOrgin("AMS");
		param.setDepart("04/22/2019");
		param.setDestination("DXB");
		
		HttpEntity<SearchParam> entity = new HttpEntity<SearchParam>(param, headers);
		
		ResponseEntity<Response> responseEnty = restTemplate.exchange(
				createURLWithPort("/searchFares"), HttpMethod.POST, entity,
				Response.class);
		assertThat(!responseEnty.getBody().getFares().isEmpty());
		
	}
	
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testValidDataWithNoFaresConfigured () {
		SearchParam param = new SearchParam();
		param.setOrgin("AMS");
		param.setDepart("04/22/2020");
		param.setDestination("DXB");
		
		HttpEntity<SearchParam> entity = new HttpEntity<SearchParam>(param, headers);
		
		ResponseEntity<Response> responseEnty = restTemplate.exchange(
				createURLWithPort("/searchFares"), HttpMethod.POST, entity,
				Response.class);
		assertThat(responseEnty.getBody().getFares().isEmpty());
		
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testWithoutOrigin () {
		SearchParam param = new SearchParam();
		param.setDepart("04/22/2020");
		param.setDestination("DXB");
		
		HttpEntity<SearchParam> entity = new HttpEntity<SearchParam>(param, headers);
		
		ResponseEntity<Response> responseEnty = restTemplate.exchange(
				createURLWithPort("/searchFares"), HttpMethod.POST, entity,
				Response.class);
		assertThat(responseEnty.getBody().getFares().isEmpty());
		
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testWithoutDestination () {
		SearchParam param = new SearchParam();
		param.setOrgin("AMS");
		param.setDepart("04/22/2020");
		
		HttpEntity<SearchParam> entity = new HttpEntity<SearchParam>(param, headers);
		
		ResponseEntity<Response> responseEnty = restTemplate.exchange(
				createURLWithPort("/searchFares"), HttpMethod.POST, entity,
				Response.class);
		assertThat(responseEnty.getBody().getFares().isEmpty());
		
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testWithoutDate () {
		SearchParam param = new SearchParam();
		param.setOrgin("AMS");
		param.setDestination("DXB");
		HttpEntity<SearchParam> entity = new HttpEntity<SearchParam>(param, headers);
		
		ResponseEntity<Response> responseEnty = restTemplate.exchange(
				createURLWithPort("/searchFares"), HttpMethod.POST, entity,
				Response.class);
		assertThat(responseEnty.getBody().getFares().isEmpty());
		
	}
	
	
	
	
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + "/travel"+uri;
	}

}
