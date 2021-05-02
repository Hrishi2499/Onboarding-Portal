package com.training.msau.controller;

import java.util.ArrayList;
import java.util.List;

import java.net.URI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.training.msau.model.Candidate;
import com.training.msau.model.Onboard;

import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestOnboardController {
	 List<Onboard> list;
	 @LocalServerPort
	 private int port;

	 TestRestTemplate restTemplate = new TestRestTemplate();
	 
	 HttpHeaders headers = new HttpHeaders();
	 HttpEntity<List<Onboard>> entity = new HttpEntity<List<Onboard>>(null, headers);
	 @SuppressWarnings("unchecked")
	 Class<List<Onboard>> onb = (Class) List.class;
	
	String baseURL = "http://localhost:8080/api/v1";
	
	@BeforeEach
	public void setup() {
		list = new ArrayList<>();
		Onboard o = new Onboard();
		Candidate c = new Candidate();
		c.setCandidateId(4);
		c.setCollege("DJ");
		c.setFirstName("Hrishi");
		c.setLastName("Shenai");
		c.setSkill("Java");
		o.setCandidate(c);
		o.setCandidateId(4);
		//o.setOnboardId(42);
		o.setHmId(101);
		o.setLocation("Sample");
		o.setOnboardStatus("Sample");
		list.add(o);
	}
	
	@Test
	public void testGetAllOnboards() throws Exception{

    	URI url = new URI(baseURL + "/onboards");
        ResponseEntity<List<Onboard>> response = restTemplate.exchange( url, HttpMethod.GET, entity, onb);

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertTrue(response.getBody().size() == 7);
        
        
	}
	
	@Test
	public void testGetOnboardbyCandidateId() throws Exception{
     	
    	URI url = new URI(baseURL + "/onboards/candidateId=1");
        ResponseEntity<List<Onboard>> response = restTemplate.exchange( url, HttpMethod.GET, entity, 
        										new ParameterizedTypeReference<List<Onboard>>() { });
      
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertTrue(response.getBody().size() == 1);
        assertTrue(response.getBody().get(0).getCandidateId() == 1);
	}
	
	@Test
	public void testGetOnboardbyOnboardId() throws Exception{
    	URI url = new URI(baseURL + "/onboards/onboardId=52");
        ResponseEntity<List<Onboard>> response = restTemplate.exchange( url, HttpMethod.GET, entity, 
        										new ParameterizedTypeReference<List<Onboard>>() { });
      
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertTrue(response.getBody().size() == 1);
        assertTrue(response.getBody().get(0).getOnboardId() == 52);
	}
	
	@Test
	public void testGetOnboardbyHmId() throws Exception{
    	URI url = new URI(baseURL + "/onboards/hmId=101");
        ResponseEntity<List<Onboard>> response = restTemplate.exchange( url, HttpMethod.GET, entity, 
        										new ParameterizedTypeReference<List<Onboard>>() { });
      
        
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertTrue(response.getBody().size() == 2);
        for(Onboard o: response.getBody()) {
            assertTrue(o.getHmId() == 101);
        }
	}
	
	@Test
	public void testGetOnboardbyFirstName() throws Exception{

    	URI url = new URI(baseURL + "/onboards/firstName=Hrishi");
        ResponseEntity<List<Onboard>> response = restTemplate.exchange( url, HttpMethod.GET, entity, 
        										new ParameterizedTypeReference<List<Onboard>>() { });
      
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertTrue(response.getBody().size() == 2);
        for(Onboard o: response.getBody()) {
            assertTrue(o.getCandidate().getFirstName().contains("Hrishi"));
        }
	}
	
	@Test
	public void testGetOnboardbyLastName() throws Exception{
    	
    	URI url = new URI(baseURL + "/onboards/lastName=Shenai");
        ResponseEntity<List<Onboard>> response = restTemplate.exchange( url, HttpMethod.GET, entity, 
        										new ParameterizedTypeReference<List<Onboard>>() { });
      
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertTrue(response.getBody().size() == 1);
        for(Onboard o: response.getBody()) {
            assertTrue(o.getCandidate().getLastName().contains("Shenai"));
        }
	}
	
	@Test
	public void testGetOnboardbyLocation() throws Exception{

    	URI url = new URI(baseURL + "/onboards/location=Mumbai");
        ResponseEntity<List<Onboard>> response = restTemplate.exchange( url, HttpMethod.GET, entity, 
        										new ParameterizedTypeReference<List<Onboard>>() { });
      
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertTrue(response.getBody().size() == 2);
        for(Onboard o: response.getBody()) {
            assertTrue(o.getLocation().contains("Mumbai"));
        }
	}
	
	@Test
	public void testGetOnboardbyCollege() throws Exception{
    	URI url = new URI(baseURL + "/onboards/college=DJ");
        ResponseEntity<List<Onboard>> response = restTemplate.exchange( url, HttpMethod.GET, entity, 
        										new ParameterizedTypeReference<List<Onboard>>() { });
      
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertTrue(response.getBody().size() == 2);
        for(Onboard o: response.getBody()) {
            assertTrue(o.getCandidate().getCollege().contains("DJ"));
        }
    	
	}
	
	@Test
	public void testGetOnboardbySkill() throws Exception{
    	URI url = new URI(baseURL + "/onboards/skill=Angular");
        ResponseEntity<List<Onboard>> response = restTemplate.exchange( url, HttpMethod.GET, entity, 
        										new ParameterizedTypeReference<List<Onboard>>() { });
      
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertTrue(response.getBody().size() == 3);
        for(Onboard o: response.getBody()) {
            assertTrue(o.getCandidate().getSkill().contains("Angular"));
        }
    	
    	
	}
	
	@Test
	public void testGetOnboardbyOnboardStatus() throws Exception{
 
    	URI url = new URI(baseURL + "/onboards/onboardStatus=Completed");
        ResponseEntity<List<Onboard>> response = restTemplate.exchange( url, HttpMethod.GET, entity, 
        										new ParameterizedTypeReference<List<Onboard>>() { });
      
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertTrue(response.getBody().size() == 2);
        for(Onboard o: response.getBody()) {
            assertTrue(o.getOnboardStatus().contains("Completed"));
        }
    	
	}
	
	@Test
	public void testAddOnboard() throws Exception{

		URI url = new URI(baseURL + "/onboards");
		HttpEntity<Onboard> entity = new HttpEntity<Onboard>(list.get(0), headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, entity, 
        											new ParameterizedTypeReference<String>() { });
        System.out.println(response.getStatusCode());
        assertTrue(response.getStatusCode()== HttpStatus.OK);
	
	}
	
	@Test
	public void testDeleteOnboard() throws Exception{
		URI url = new URI(baseURL + "/onboards");
		HttpEntity<Onboard> entity = new HttpEntity<Onboard>(list.get(0), headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, 
        											new ParameterizedTypeReference<String>() { });
        System.out.println(response.getStatusCode());
        assertTrue(response.getStatusCode()== HttpStatus.OK);
	}
	
	@Test
	public void testUpdateOnboard() throws Exception{
		URI url = new URI(baseURL + "/onboards/onboardId=106&user=null&userEmail=null");
		HttpEntity<Object> entity = new HttpEntity<Object>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, entity, 
        											new ParameterizedTypeReference<String>() { });
        System.out.println(response.getStatusCode());
        assertTrue(response.getStatusCode()== HttpStatus.OK);
	}
}
