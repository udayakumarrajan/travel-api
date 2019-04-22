/**
 * 
 */
package com.afkl.cases.df.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.afkl.cases.df.Bootstrap;

/**
 * @author udayakumar.rajan
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Bootstrap.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AirportControllerTest {

	@LocalServerPort
	private int port;
	
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testRetrunAllAiports() throws Exception {
		ResponseEntity<List> responseEnty = restTemplate.exchange(
				createURLWithPort("/getAirports"), HttpMethod.GET, null,
				List.class);
		assertNotNull(responseEnty.getBody());
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testFilterAiports() throws Exception {
		ResponseEntity<List> responseEnty = restTemplate.exchange(
				createURLWithPort("/searchAirports?filter=Du"), HttpMethod.POST, null,
				List.class);
		assertNotNull(responseEnty.getBody());
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testFilterInvalidAiports() throws Exception {
		ResponseEntity<List> responseEnty = restTemplate.exchange(
				createURLWithPort("/searchAirports?filter=12"), HttpMethod.POST, null,
				List.class);
		assertThat(responseEnty.getBody().isEmpty());
	}
	
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + "/travel"+uri;
	}

}
